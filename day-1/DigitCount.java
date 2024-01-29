import java.util.Scanner;

public class DigitCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int digitCount = countDigits(number);
        System.out.println("Number of digits in " + number + " is: " + digitCount);

        scanner.close();
    }

    public static int countDigits(int number) {
        if (number == 0) {
            return 1; // Special case for number 0
        }

        int count = 0;
        while (number != 0) {
            count++;
            number = number / 10; // Remove the last digit
        }
        return count;
    }
}

