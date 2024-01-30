package BasicPractice;
import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        int x,y, temp = 0;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter two numbers");
        x = scanner.nextInt();
        y = scanner.nextInt();

        System.out.println("Numbers before swap are x & y: " + x +" "+ y);
        temp = x;
        x = y;
        y = temp;

        System.out.println("Swapped numbers are x & y: "+ x +" " +y);
    }

}
