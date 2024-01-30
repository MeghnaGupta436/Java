package BasicPractice;

import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args){
        int x,y,max=0;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter 2 numbers");
        x= scanner.nextInt();
        y= scanner.nextInt();

        if(x>y)
        {
            max = x;
            System.out.println("the value of " + x + " is maximum");
        }
        else {
            max = y;
            System.out.println("the value of " + y + " is maximum");
        }
    }
}
