import java.util.*;

public class StringIntroduction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read two strings
        String A = sc.nextLine();
        String B = sc.nextLine();

        // Operation 1: Sum of lengths
        System.out.println(A.length() + B.length());

        // Operation 2: Lexicographical comparison
        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // Operation 3: Capitalize first letters
        A = A.substring(0, 1).toUpperCase() + A.substring(1);
        B = B.substring(0, 1).toUpperCase() + B.substring(1);

        System.out.println(A + " " + B);

        sc.close();
    }
}
