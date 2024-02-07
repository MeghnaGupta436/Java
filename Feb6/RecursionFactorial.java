package Feb6;
import java.util.*;
public class RecursionFactorial //To find Factorial of a number using Recursion
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number to find Factorial");
        double n=sc.nextInt();// input the number entered by user
        double result=factorial(n);//function calling
        System.out.println("The factorial of a number is"+ result);//displaying result
    }
    public static double factorial(double x)// function defination to find factorial
    {
        if(x>0)
        {
            return x * factorial(x-1);//recursion as the faction is calling itself
        }
        else// halting condition which stops recursion
        {
            return 1;
        }
    }
}
