package Feb6;
import java.util.*;
public class PalindromeStrRecursion
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String str=sc.nextLine(); //to get the string entered by user
        int j=str.length();
        boolean result=IsPalindromeOrNot(str,0,j-1);
        System.out.println(result);
    }
    public static boolean IsPalindromeOrNot(String str,int i,int j)//boolean function to print true or false
    {
        if(i>=j)
            return true;
        if (str.charAt(i) != str.charAt(j))
            return false;//if the characters matched is not same
        else
            return IsPalindromeOrNot(str,i+1,j-1);

    }
}
