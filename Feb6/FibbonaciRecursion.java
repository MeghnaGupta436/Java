package Feb6;
import java.util.*;
public class FibbonaciRecursion// finding fibonacci series element using recursion
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of element you want to access in series");
        int n=sc.nextInt(); //input value entered by user

        int result=fibonacci(n); //calling function
        System.out.println("The "+n+"th element of the series is: "+result); //displaying the requested element
    }
    public static int fibonacci(int x) //function defination to find element  in the series
    {
    if(x==1)//halting condition
    {
        return 0;
    }
    else if(x==2)
    {
        return 1;
    }
    else
    {
        return fibonacci(x-1)+ fibonacci(x-2);//returning the required element to the function
    }
    }
}
