package BasicPractice;
import java.util.Scanner;
public class FibonacciSeries {
    public static void main(String[] args)
    {
        int num,a=0,b=1,sum=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Range");
        num=scanner.nextInt();

        System.out.println("Fibonacci series: ");
        System.out.println("0");
        for(int i=1;i<=num;i++)
        {
            sum=a+b;
            a=b;
            b=sum;
            System.out.println(sum);
        }
    }
}
