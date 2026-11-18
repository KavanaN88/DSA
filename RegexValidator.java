import java.util.*;
import java.util.regex.*;

public class RegexValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        int n = sc.nextInt();
        sc.nextLine();

        // Check each pattern
        for (int i = 0; i < n; i++) {

            String pattern = sc.nextLine();

            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            }
            catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
        }

        sc.close();
    }
}
