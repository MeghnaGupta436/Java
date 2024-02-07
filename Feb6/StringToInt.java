import java.util.Scanner;

public class StringToInt { //to find the integer value of a numeric string
    public static int convertStrToInt(String s) {
        if (s.isEmpty()) //base case
        {
            return 0;
        }

        int digit = Character.getNumericValue(s.charAt(0)); //extract 1st and convert it
        //recursively converting rest string
        return digit * (int)Math.pow(10, s.length() - 1) + convertStrToInt(s.substring(1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a numeric string: ");
        String inputString = scanner.nextLine().trim();//input string y user
        scanner.close();

        try {
            int result = convertStrToInt(inputString);// to covert string ti integer
            System.out.println("Integer representation of the input string: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid numeric string.");
        }
    }
}
