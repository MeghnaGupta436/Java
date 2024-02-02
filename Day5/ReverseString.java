package Day5;
import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a string");
        String str=scanner.nextLine();

        char[] ch=str.toCharArray();
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
    }
}
