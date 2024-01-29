import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of rows
        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();

        // Print the pattern
        for (int i = 1; i <= n; i++) {
            // Print numbers in descending order
            for (int k = i; k >= 1; k--) {
                System.out.print(k);
            }
            // Print spaces
            for (int j = n - i; j >= 1; j--) {
                System.out.print(" ");
            }
            // Move to the next line
            System.out.println();
        }

        // Close the scanner
        scanner.close();
    }
}
