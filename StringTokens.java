import java.util.Scanner;

public class StringTokens {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read complete sentence
        String s = sc.nextLine();

        // Split using regular expression
        String[] words = s.split("[^a-zA-Z]+");

        // Count tokens
        int count = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }

        // Print total tokens
        System.out.println(count);

        // Print each token
        for (String word : words) {
            if (!word.isEmpty()) {
                System.out.println(word);
            }
        }

        sc.close();
    }
}
