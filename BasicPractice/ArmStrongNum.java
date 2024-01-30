package BasicPractice;
import java.util.Scanner;
public class ArmStrongNum {
    public static void main(String[] args){
        int n,r,c=0,sum=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number");
        n=scanner.nextInt();
        int num=n;
        while(n!=0)
        {
            r = n % 10;
            n = n / 10;
            c = r * r * r;
            sum = sum + c;
        }

        if(sum==num)
        {
            System.out.println("The number entered is Armstrong");
        }
         else{
            System.out.println("The number entered is Not Armstrong");
        }
    }
}
