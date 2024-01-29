import java.util.Scanner;

public class FacExpt1_No {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Calculate and print factors except 1 and the number itself
        System.out.print("Factors except 1 and the number itself: ");
        if (number <= 1) {
            System.out.println("Invalid input.");
        } else {
            boolean hasFactorsOtherThanOneAndNumber = false;
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    if (hasFactorsOtherThanOneAndNumber) {
                        System.out.print(", ");
                    }
                    System.out.print(i);
                    hasFactorsOtherThanOneAndNumber = true;
                }
            }
            if (!hasFactorsOtherThanOneAndNumber) {
                System.out.print("-1");
            }
            System.out.println();
        }

        // Close the scanner
        scanner.close();
    }
}

