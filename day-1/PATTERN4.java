import java.util.Scanner;

public class PATTERN4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of rows
        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();

        // Initialize the starting character
        char ch = 'E';

        // Print the pattern
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print characters
            for (int k = 1; k <= i; k++) {
                System.out.print(ch++);
            }
            // Move to the next line
            System.out.println();
            // Reset the character for the next row
            ch = (char) ('E' - i);
        }

        // Close the scanner
        scanner.close();
    }
}
