
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        // Create Scanner object to read input
        Scanner sc = new Scanner(System.in);

        // Initialize line number starting from 1
        int i = 1;

        // Read input continuously until EOF is reached
        while (sc.hasNextLine()) {

            // Read the complete line of input
            String line = sc.nextLine();

            // Print line number followed by the input content
            System.out.println(i + " " + line);

            // Increment line number for the next line
            i++;
        }

        // Close the Scanner object
        sc.close();
    }
}
