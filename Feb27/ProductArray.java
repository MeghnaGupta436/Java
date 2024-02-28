package Feb27;
import java.util.Scanner;
public class ProductArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of array");
        int n= sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the items of array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("The resultant array is: ");
        for (int i = 0; i < arrayProducts(n, arr).length; i++) {
            System.out.print(arrayProducts(n, arr)[i]+" ");
        }
    }
    public static int[] arrayProducts(int n, int arr[]){
        int[] rarr=new int[n];
        //easy way to do this
        int prod=1;
        for(int i=0;i<n;i++) {
            prod *= arr[i];}
        for (int i = 0; i < n; i++) {
            rarr[i] = prod/arr[i];
        }
        return rarr;
    }
}

//another way to do this
//        for(int i=0;i<n;i++) {
//            int prod=1;
//            for (int j = 0; j < n; j++) {
//            if(i==j)
//                continue;
//            else
//                prod=prod*arr[j];
//            }
//            rarr[i]=prod;
//        }
//        return rarr;