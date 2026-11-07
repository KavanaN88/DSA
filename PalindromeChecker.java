import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();

        // Reverse the string
        String reverse = new StringBuilder(A).reverse().toString();

        // Compare original and reversed strings
        if (A.equals(reverse)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        sc.close();
    }
}
