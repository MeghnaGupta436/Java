import java.util.Scanner;

public class RemoveDuplicate {

    public static String removeDuplicates(String s) {
        if (s.length() <= 1) {
            return s; // Base case: if the string has 1 or fewer characters, no duplicates to remove
        }

        // Check if the first two characters are duplicates
        if (s.charAt(0) == s.charAt(1)) {
            // Skip the adjacent duplicates and recursively call removeDuplicates on the rest of the string
            return removeDuplicates(s.substring(2));
        } else {
            // Keep the current character and recursively call removeDuplicates on the rest of the string
            return s.charAt(0) + removeDuplicates(s.substring(1));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        scanner.close();

        String result = removeDuplicates(inputString);
        System.out.println("String after removing adjacent duplicates: " + result);
    }
}
