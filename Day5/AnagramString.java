import java.util.*;

public class AnagramString{
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.println("Enter 1st String");
        String str1 = sr.nextLine();
        System.out.println("Enter 2nd String");
        String str2 = sr.nextLine();

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        if (Arrays.equals(ch1, ch2)) {
            System.out.println("strings are Anagram");
        } else {
            System.out.println("Strings are not Anagram");
        }
    }
}
