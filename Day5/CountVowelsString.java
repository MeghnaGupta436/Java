import java.util.Scanner;
public class CountVowelsString{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String str=sc.nextLine();
        int l=str.length();
        int cV=0;
        for(int i=0;i<l;i++)
        {
        char c=str.charAt(i);
        if(c=='a'|| c=='e'||c=='i'||c=='o'||c=='u')
        {
            cV++;
        }
        }
        System.out.println(cV);
    }
}
