import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of rows
        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();

        // Character to start with
        char ch = 'A';

        // Print the pattern
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= i; j++) {
                System.out.print(ch++);
            }
            // Move to the next line
            System.out.println();
        }

        // Close the scanner
        scanner.close();
    }
}
