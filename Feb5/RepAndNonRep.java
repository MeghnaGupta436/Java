import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepAndNonRep{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        scanner.close();

        printRepAndNonRep(input);
    }

    public static void printRepAndNonRep(String input) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        // Count frequency of each character
        for (char c : input.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        // Print repeated characters
        System.out.print("Repeated characters: ");
        for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();

        // Print non-repeated characters
        System.out.print("Non-repeated characters: ");
        for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
