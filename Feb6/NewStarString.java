package Feb6;
import java.util.*;
public class NewStarString
{
    static String NewStr=""; //global string
    public static void main(String[] args)//append * in between same characters in a string
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String"); //string input
        String str=sc.nextLine();
        NewStr=NewString(str,0); //Assigning function return to new string
        System.out.println("New String is: "+ NewStr); //display newstring
    }
    public static String NewString(String str,int i) //new string function
    {
        if(i==str.length()-1) //halting condition
            return NewStr+ str.charAt(str.length()-1);
        else if (str.charAt(i)!=str.charAt(i+1)) //comparing adjacent characters
             NewStr=NewStr + str.charAt(i);
        else
             NewStr=NewStr + str.charAt(i)+'*'; //adding star to character in string
        return NewString(str, i + 1); //recursive function
    }
}
