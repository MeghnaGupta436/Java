package BasicPractice;
import java.util.Scanner;
public class CountEvenOddZero {
    public static void main(String[] args)
    {
        int num,rem;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number");
        num=scanner.nextInt();
        int n=num,ec=0,oc=0,zc=0;
        while(n!=0)
        {
            rem=n%10;
            if(n%10==0)
                zc++;
            else if(rem%2==0)
            {
                ec++;
            }
            else {
                oc++;
            }
            n=n/10;


        }
        System.out.println("Number of even digits are "+ ec);
        System.out.println("Number of odd digits are " +oc);
        System.out.println("Number of zeroes in number are " +zc);
    }
}
