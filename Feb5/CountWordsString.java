package Feb5;
import java.util.*;
public class CountWordsString
 {
     public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            scanner.close();

            int wordCount = countWords(input);
            System.out.println("Number of words: " + wordCount);
        }
        public static int countWords(String input) {
            if (input == null || input.isEmpty()) {
                return 0;
            }

            String[] words = input.split("\\s+");
            return words.length;
        }
    }


