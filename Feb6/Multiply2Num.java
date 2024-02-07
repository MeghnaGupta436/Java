package Feb6;
import java.util.*;
public class Multiply2Num //multiplying using recursion
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter two numbers to multiply");
        int m=sc.nextInt(); //value 1 input
        int n=sc.nextInt(); //value 2 input
        int result=Multiply(m,n); //function call
        System.out.println("Multiplication of numbers entered is "+result); //display result
    }
    public static int Multiply(int m,int n) //multiplication fuction
    {
        if(m==0 || n==0) //halting condition
            return 0;
        else
            return m+ Multiply(m,n-1); //fuunction recursion
    }
}
