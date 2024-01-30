package BasicPractice;
import java.util.Scanner;
public class factNum{
    public static void main(String[] args){
        int x,fact=1;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number ");
        x= scanner.nextInt();
        for(int i=1;i<=x;i++)
        {
            fact=fact*i;
        }
        System.out.println("Factorial of number is "+fact);

    }
}
