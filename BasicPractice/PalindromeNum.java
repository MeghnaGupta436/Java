package BasicPractice;
import java.util.Scanner;
public class PalindromeNum {
    public static void main(String[] args){
        int num,rev=0,rem;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter a number");
        num=scanner.nextInt();
        int n=num;
        while(n!=0)
        {
            rem = n% 10;
            rev = (rev*10) + rem;
            n = n/ 10;
        }
        if(rev==num)
        {
            System.out.println("The Number is palindrome");
        }
        else
        {
            System.out.println("Number is not Palindrome");
        }


    }
}
