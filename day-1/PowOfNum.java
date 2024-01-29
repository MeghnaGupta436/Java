import java.util.Scanner;

public class PowOfNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the base (x) and the exponent (n)
        System.out.print("Enter the base (x): ");
        double x = scanner.nextDouble();

        System.out.print("Enter the exponent (n): ");
        int n = scanner.nextInt();

        // Calculate x^n
        double result = 1;
        for (int i = 0; i < Math.abs(n); i++) {
            result *= x;
        }

        // If n is negative, take the reciprocal
        if (n < 0) {
            result = 1 / result;
        }

        // Print the result
        System.out.println("Result: " + result);

        // Close the scanner
        scanner.close();
    }
}

