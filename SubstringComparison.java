
import java.util.Scanner;

public class SubstringComparison {

    public static String getSmallestAndLargest(String s, int k) {

        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        // Check all possible substrings
        for (int i = 0; i <= s.length() - k; i++) {

            String sub = s.substring(i, i + k);

            // Find lexicographically smallest
            if (sub.compareTo(smallest) < 0) {
                smallest = sub;
            }

            // Find lexicographically largest
            if (sub.compareTo(largest) > 0) {
                largest = sub;
            }
        }

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        int k = scan.nextInt();

        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
