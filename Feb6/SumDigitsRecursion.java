package Feb6;
import java.util.*;
public class SumDigitsRecursion //Sum of digits of number using recursion
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num=sc.nextInt(); //number input
        int sum=SumDigits(num); //function call
        System.out.println("The sum of digits is "+sum); //display sum
    }
    public static int SumDigits(int x) //sum of digits fuction
    {
        if(x<=0) //halting condition
            return 0;
        else
            return (x%10)+ SumDigits(x/10); //recursive function
    }
}
