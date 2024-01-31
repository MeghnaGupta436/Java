package Day3;
import java.util.Scanner;
import java.util.ArrayList;
public class EvenOddArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();
        System.out.println("Enter the elements: ");

        for(int i=0; i<size; i++){
            nums[i] = sc.nextInt();
        }

        for(int n:nums){
            if(n%2==0){
                evenList.add(n);
            }
            else{
                oddList.add(n);
            }
        }
        for(int n:evenList){
            System.out.print(n+" ");

        }
        System.out.println();
        for(int n:oddList){
            System.out.print(n+" ");

        }
    }
}