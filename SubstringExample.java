import java.util.*;

public class SubstringExample {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Read string
        String s = in.next();

        // Read starting and ending indexes
        int start = in.nextInt();
        int end = in.nextInt();

        // Extract and print substring
        System.out.println(s.substring(start, end));

        in.close();
    }
}
