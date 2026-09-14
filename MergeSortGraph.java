
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class MergeSortGraph extends JPanel {

    static int[] sizes;
    static double[] times;

    // Merge Sort Method
    public static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = left + (right - left) / 2;

            // Sort left half
            mergeSort(arr, left, mid);

            // Sort right half
            mergeSort(arr, mid + 1, right);

            // Merge both halves
            merge(arr, left, mid, right);
        }
    }

    // Merge Method
    public static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy elements into temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Merge the two sorted arrays
        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements from left array
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from right array
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Run experiment and calculate execution time
    public static void runExperiment() {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter number of test cases: ");
        int testCases = sc.nextInt();

        sizes = new int[testCases];
        times = new double[testCases];

        for (int k = 0; k < testCases; k++) {

            int n;

            // Validate n
            while (true) {

                System.out.print(
                    "Enter number of elements n (greater than 5000): "
                );

                n = sc.nextInt();

                if (n > 5000) {
                    break;
                }

                System.out.println(
                    "Invalid value! Please enter n greater than 5000."
                );
            }

            sizes[k] = n;

            int[] arr = new int[n];

            // Generate random elements
            for (int i = 0; i < n; i++) {
                arr[i] = random.nextInt(100000);
            }

            // Start timer
            long startTime = System.nanoTime();

            // Perform Merge Sort
            mergeSort(arr, 0, n - 1);

            // End timer
            long endTime = System.nanoTime();

            // Convert nanoseconds to seconds
            times[k] =
                (endTime - startTime) / 1_000_000_000.0;

            System.out.printf(
                "n = %d | Time taken = %.6f seconds%n",
                n,
                times[k]
            );
        }
    }

    // Draw Graph
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        setBackground(Color.WHITE);

        Graphics2D g2 = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        // Graph margins
        int left = 100;
        int right = width - 70;
        int top = 70;
        int bottom = height - 100;

        // Title
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 22));

        String title = "Merge Sort Time Complexity";

        FontMetrics fm = g2.getFontMetrics();

        int titleX =
            (width - fm.stringWidth(title)) / 2;

        g2.drawString(title, titleX, 40);

        // Draw axes
        g2.drawLine(left, top, left, bottom);
        g2.drawLine(left, bottom, right, bottom);

        // Find minimum and maximum n
        int minN = sizes[0];
        int maxN = sizes[0];
        double maxTime = times[0];

        for (int i = 0; i < sizes.length; i++) {

            if (sizes[i] < minN) {
                minN = sizes[i];
            }

            if (sizes[i] > maxN) {
                maxN = sizes[i];
            }

            if (times[i] > maxTime) {
                maxTime = times[i];
            }
        }

        // Add extra space above maximum time
        maxTime = maxTime * 1.15;

        // Draw horizontal grid lines
        int gridLines = 5;

        g2.setFont(
            new Font("Arial", Font.PLAIN, 13)
        );

        for (int i = 0; i <= gridLines; i++) {

            int y =
                bottom -
                i * (bottom - top) / gridLines;

            double timeValue =
                (maxTime * i) / gridLines;

            // Draw grid line
            g2.setColor(Color.LIGHT_GRAY);

            g2.drawLine(left, y, right, y);

            // Display time value
            g2.setColor(Color.BLACK);

            String label =
                String.format("%.4f", timeValue);

            g2.drawString(label, 35, y + 5);
        }

        // Draw vertical grid lines and X-axis labels
        for (int i = 0; i < sizes.length; i++) {

            int x;

            if (maxN == minN) {

                x = (left + right) / 2;

            } else {

                x = left + (int) (
                    ((double) (sizes[i] - minN)
                    / (maxN - minN))
                    * (right - left)
                );
            }

            // Draw vertical grid line
            g2.setColor(Color.LIGHT_GRAY);

            g2.drawLine(x, top, x, bottom);

            // Display n value
            g2.setColor(Color.BLACK);

            String nLabel =
                String.valueOf(sizes[i]);

            FontMetrics metrics =
                g2.getFontMetrics();

            g2.drawString(
                nLabel,
                x - metrics.stringWidth(nLabel) / 2,
                bottom + 25
            );
        }

        // Draw lines between points
        g2.setColor(new Color(30, 100, 150));

        for (int i = 0; i < sizes.length - 1; i++) {

            int x1 = calculateX(
                sizes[i], minN, maxN, left, right
            );

            int y1 = calculateY(
                times[i], maxTime, top, bottom
            );

            int x2 = calculateX(
                sizes[i + 1], minN, maxN, left, right
            );

            int y2 = calculateY(
                times[i + 1], maxTime, top, bottom
            );

            g2.drawLine(x1, y1, x2, y2);
        }

        // Draw graph points
        for (int i = 0; i < sizes.length; i++) {

            int x = calculateX(
                sizes[i], minN, maxN, left, right
            );

            int y = calculateY(
                times[i], maxTime, top, bottom
            );

            g2.setColor(new Color(30, 100, 150));

            g2.fillOval(x - 5, y - 5, 10, 10);
        }

        // X-axis label
        g2.setColor(Color.BLACK);

        g2.setFont(
            new Font("Arial", Font.BOLD, 15)
        );

        String xAxis =
            "Number of Elements (n)";

        FontMetrics xMetrics =
            g2.getFontMetrics();

        g2.drawString(
            xAxis,
            (width - xMetrics.stringWidth(xAxis)) / 2,
            height - 35
        );

        // Y-axis label
        Graphics2D gY =
            (Graphics2D) g2.create();

        gY.rotate(-Math.PI / 2);

        String yAxis =
            "Time Taken (seconds)";

        FontMetrics yMetrics =
            gY.getFontMetrics();

        gY.drawString(
            yAxis,
            -(height + yMetrics.stringWidth(yAxis)) / 2,
            25
        );

        gY.dispose();
    }

    // Calculate X coordinate
    public int calculateX(
        int value,
        int min,
        int max,
        int left,
        int right
    ) {

        if (max == min) {
            return (left + right) / 2;
        }

        return left + (int) (
            ((double) (value - min) / (max - min))
            * (right - left)
        );
    }

    // Calculate Y coordinate
    public int calculateY(
        double value,
        double maxTime,
        int top,
        int bottom
    ) {

        return bottom - (int) (
            (value / maxTime)
            * (bottom - top)
        );
    }

    public static void main(String[] args) {

        // Run experiment
        runExperiment();

        // Create graph window
        JFrame frame =
            new JFrame("Merge Sort Time Complexity");

        MergeSortGraph graph =
            new MergeSortGraph();

        frame.add(graph);

        frame.setSize(900, 600);

        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
