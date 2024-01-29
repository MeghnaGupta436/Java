import java.util.Scanner;

public class SumOddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter an integer
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();

        // Calculate the sum of even and odd digits separately
        int sumOfEvenDigits = 0;
        int sumOfOddDigits = 0;
        int number = Math.abs(n); // Absolute value in case n is negative
        while (number > 0) {
            int digit = number % 10; // Extract the last digit
            if (digit % 2 == 0) { // Check if the digit is even
                sumOfEvenDigits += digit;
            } else { // Digit is odd
                sumOfOddDigits += digit;
            }
            number /= 10; // Remove the last digit
        }

        // Print the sum of even and odd digits separately
        System.out.println("Sum of even digits: " + sumOfEvenDigits);
        System.out.println("Sum of odd digits: " + sumOfOddDigits);

        // Close the scanner
        scanner.close();
    }
}

