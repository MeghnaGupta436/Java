import java.util.Scanner;

public class recursionAAndB { //check a string is valid or not

    public static boolean checkString(String s) {
        if (s.isEmpty()) //base case
        {
            return true;
        }

        if (s.charAt(0) == 'a') //checking if string starts with a
        {
            return checkString(s.substring(1));//checking rest string recursively
        }

        if (s.startsWith("bb")) //checking if string starts with bb
        {
            return checkString(s.substring(2));//checking rest string recursively
        }

        return false;//if no condition above is met
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string made up of 'a's and 'b's: ");
        String inputString = scanner.nextLine().trim();//input string
        scanner.close();

        boolean isValid = checkString(inputString); //function call
        if (isValid) {
            System.out.println("The string follows the rules.");
        } else {
            System.out.println("The string does not follow the rules.");
        }
    }
}
