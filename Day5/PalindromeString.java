import java.util.Scanner;

public class PalindromeString {
        public static void main(String[] args)
        {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter a string: ");
            String str=scanner.nextLine();
            String str1=str.toLowerCase();

            char[] ch=str1.toCharArray();
            int a=0;
            int b=ch.length-1;
            while(a<=b){
                char temp = ch[a];
                ch[a] = ch[b];
                ch[b] = temp;
                a++;
                b--;
            }
            String ans = new String(ch);
            System.out.println(ans);

            if(str1.equals(ans))
            {
                System.out.println("String is palindrome");
            }
            else
            {
                System.out.println("String is not Palindrome");
            }
        }
        }

