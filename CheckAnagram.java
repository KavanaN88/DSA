import java.util.Scanner;

public class CheckAnagram {

    static boolean isAnagram(String a, String b) {

        // Convert strings to lowercase
        a = a.toLowerCase();
        b = b.toLowerCase();

        // Check lengths
        if (a.length() != b.length()) {
            return false;
        }

        // Create frequency array
        int[] count = new int[26];

        // Count character frequencies
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;
        }

        // Check frequencies
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string:");
        String a = sc.next();

        System.out.println("Enter second string:");
        String b = sc.next();

        if (isAnagram(a, b)) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }

        sc.close();
    }
}
