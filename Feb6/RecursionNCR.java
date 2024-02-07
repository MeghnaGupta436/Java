package Feb6;
import java.util.*;
public class RecursionNCR {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the value of n: ");
            int n = scanner.nextInt(); //input value of n

            System.out.print("Enter the value of r: ");
            int r = scanner.nextInt(); //input r

            scanner.close();

            if (n < r) {
                System.out.println("Invalid input! n should be greater than or equal to r.");
            } else {
                int result = nCr(n, r); //function call
                System.out.println("Value of " + n + "C" + r + " is: " + result);
            }
        }
        public static int factorial(int n) //factorial function
        {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1); //factorial recursion
    }
    public static int nCr(int n, int r) //ncr function
    {
        if (r == 0 || r == n) //base case
        {
            return 1;
        }

        return factorial(n) / (factorial(r) * factorial(n - r)); //recursive call
    }
    }

