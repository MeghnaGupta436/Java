package Feb26;
import java.util.Scanner;

public class ScrambleString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the strings A and B
        System.out.print("Enter string A: ");
        String A = scanner.next();
        System.out.print("Enter string B: ");
        String B = scanner.next();

        // Check if B is a scrambled string of A
        boolean result = isScramble(A, B);

        System.out.println("Is \"" + B + "\" a scrambled string of \"" + A + "\"? " + result);
    }

    public static boolean isScramble(String A, String B) {
        int n = A.length();
        if (n != B.length()) {
            return false;
        }

        if (A.equals(B)) {
            return true;
        }

        // Check if the character count of A and B are equal
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[A.charAt(i) - 'a']++;
            count[B.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        // Check all possible split positions
        for (int i = 1; i < n; i++) {
            if (isScramble(A.substring(0, i), B.substring(0, i))
                    && isScramble(A.substring(i), B.substring(i))) {
                return true;
            }
            if (isScramble(A.substring(0, i), B.substring(n - i))
                    && isScramble(A.substring(i), B.substring(0, n - i))) {
                return true;
            }
        }

        return false;
    }
}
