import java.util.Scanner;
public class PrintUpperLowerCase
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a string");
        String str=scanner.nextLine();
        int l=str.length();

        UpperCase(str,l);
        LowerCase(str,l);
    }


    static void UpperCase(String str,int l)
    {
        System.out.println("Upper Case characters");
        for(int i=0;i<l;i++)
        {
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z')
                System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
    }



    static void LowerCase(String str,int l)
    {
        System.out.println("Lower Case characters");
        for(int i=0;i<l;i++)
        {
            if(str.charAt(i)>='a'&&str.charAt(i)<='z')
                System.out.print(str.charAt(i)+" ");
        }
    }

}

