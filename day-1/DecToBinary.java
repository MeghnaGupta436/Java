import java.util.Scanner;

public class DecToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a decimal number
        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();

        // Convert decimal number to binary
        String binaryNumber = Integer.toBinaryString(decimalNumber);

        // Print the binary representation
        System.out.println("Binary representation: " + binaryNumber);

        // Close the scanner
        scanner.close();
    }
}

