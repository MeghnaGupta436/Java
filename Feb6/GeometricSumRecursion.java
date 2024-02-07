package Feb6;
import java.util.*;
public class GeometricSumRecursion
{
    public static void main(String[] args)//finding the kth element in the geometric series
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of element you want from series");
        double k=sc.nextInt(); //taking input from user
        double result= GeoSum(k); //function calling
        System.out.println("The requested element of series is: "+result);
    }

    public static double GeoSum(double x) //function created to find geomatric sum
    {
        if(x==0)
        {
            return 1;
        }
        else
        {
            return (1/Math.pow(2,x)+GeoSum(x-1)) ;//recursion to find the next element of the series
        }
    }
}
