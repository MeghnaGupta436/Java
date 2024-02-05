package Feb5;
import java.util.*;
public class DisplayVowDigBlank
{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            scanner.close();

            displayChar(input);
        }
        public static void displayChar(String input) {
            int vowelCount = 0;
            int digitCount = 0;
            int blankSpaceCount = 0;

            for (char ch : input.toCharArray()) {
                if (isVowel(ch)) {
                    vowelCount++;
                } else if (Character.isDigit(ch)) {
                    digitCount++;
                } else if (Character.isWhitespace(ch)) {
                    blankSpaceCount++;
                }
            }

            System.out.println("Vowels: " + vowelCount);
            System.out.println("Digits: " + digitCount);
            System.out.println("Blank spaces: " + blankSpaceCount);
        }
        public static boolean isVowel(char ch) {
            ch = Character.toLowerCase(ch);
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        }
    }


