package Day3;
import java.util.Scanner;
public class RevArray {
    public static void main(String[] args)
    {
     int n;
     Scanner scanner=new Scanner(System.in);
        System.out.println("Enter no. of elements in array");
        n=scanner.nextInt();
        int[] arr=new int[n];
     for(int i=0;i<n;i++)
     {
        arr[i]=scanner.nextInt();
     }
        System.out.println("Reverse of array is");
    for(int i=n-1;i>=0;i--)
    {
        System.out.println( arr[i]);
    }
    }
}
