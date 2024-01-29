public class Toogle {
    public static void main(String[] args) {
        String input = "ApPLe";
        String toggledString = toggleCase(input);
        System.out.println("Toggled Case: " + toggledString);
    }

    public static String toggleCase(String str) {
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (Character.isUpperCase(c)) {
                charArray[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                charArray[i] = Character.toUpperCase(c);
            }
            // Ignore non-alphabetic characters
        }

        return new String(charArray);
    }
}
