import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count occurrences of each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        // Print unique characters that occur only once
        System.out.println("Unique non-repeated characters in the string:");
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.print(entry.getKey() + " ");
            }
        }

        scanner.close();
    }
}
