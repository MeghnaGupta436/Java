package Feb5;
import java.util.*;
public class RepWordString
{
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            scanner.close();

            RepeatedWords(input);
        }

        public static void RepeatedWords(String input) {
            String[] words = input.split("\\s+");
            Map<String, Integer> wordFrequencyMap = new HashMap<>();
            for (String word : words) {
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }

            System.out.print("Repeated words: ");
            for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
                if (entry.getValue() > 1) {
                    System.out.print(entry.getKey() + " ");
                }
            }
        }
    }



