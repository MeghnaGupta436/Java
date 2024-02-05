package Feb5;
import java.util.*;
public class RevWordsString
{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            scanner.close();

            String reversedWords = reverseWords(input);
            System.out.println("Reversed words: " + reversedWords);
        }
        public static String reverseWords(String input) {
            String[] words = input.split("\\s+");
            StringBuilder reversedString = new StringBuilder();

            for (int i = words.length - 1; i >= 0; i--) {
                reversedString.append(words[i]);
                if (i > 0) {
                    reversedString.append(" ");
                }
            }

            return reversedString.toString();
        }
    }


