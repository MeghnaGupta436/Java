package BasicPractice;
import java.util.Scanner;
public class primeNum {
    public static void main(String[] args){
        int n;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter Maximum Range");
        n= scanner.nextInt();
        for(int i=2;i<=n;i++)
        {
            int c=0;
            for(int j=2;j<=i;j++)
            {
                if(i%j==0)
                    c++;
            }
            if(c==1)
                System.out.print(i+",");
        }
    }
}
