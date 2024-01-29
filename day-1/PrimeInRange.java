import java.util.Scanner;

public class PrimeInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the decimal number
        System.out.print("Enter a decimal number (n): ");
        int n = scanner.nextInt();

        // Print prime numbers in the range 2 to n
        System.out.println("Prime numbers in the range 2 to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

        // Close the scanner
        scanner.close();
    }

    // Function to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

