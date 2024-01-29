import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of rows
        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();

        // Initialize the starting number
        int start = 1;

        // Print the pattern
        for (int i = 1; i <= n; i++) {
            int num = start;
            // Print numbers
            for (int j = 1; j <= n; j++) {
                System.out.print(num);
                num += 2;
                if (num > 9) {
                    num = num % 10 + 1;
                }
            }
            // Update the starting number for the next row
            start += 2;
            if (start > 9) {
                start = start % 10 + 1;
            }
            // Move to the next line
            System.out.println();
        }

        // Close the scanner
        scanner.close();
    }
}

