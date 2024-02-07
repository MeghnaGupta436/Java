package Feb6;
import java.util.*;
public class DigitCountZeros //to count zeros in number
{
    static int count=0;
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num=sc.nextInt(); //input number
        int result=CountDigits(num);
        System.out.println("Number of zeros: "+result);
    }
    public static int CountDigits(int num)
    {
        if(num==0)
            return 1;
        else if(num<10)
            return 0;
        else if
            ((num%10)==0 )
            return CountDigits(num/10)+1;
        else
          return  CountDigits(num/10);
    }
}
