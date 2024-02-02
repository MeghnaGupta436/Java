import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountDuplicate{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        String str1=inputString.toLowerCase();

        Map<Character, Integer> charCountMap = countDuplicateCharacters(str1);

        System.out.println("Duplicate characters and count:");
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }

        scanner.close();
    }

    private static Map<Character, Integer> countDuplicateCharacters(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        return charCountMap;
    }
}

