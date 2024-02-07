package Feb6;
import java.util.*;
public class RaisedToReverse {
        public static long powerMod(long base, long exponent, long modulus) {
            long result = 1;
            while (exponent > 0) {
                if (exponent % 2 == 1) {
                    result = (result * base) % modulus;
                }
                base = (base * base) % modulus;
                exponent /= 2;
            }
            return result;
        }

        public static long reverse(long num) {
            long rev = 0;
            while (num != 0) {
                long digit = num % 10;
                rev = rev * 10 + digit;
                num /= 10;
            }
            return rev;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number: ");
            long num = scanner.nextLong(); //input number from user
            System.out.print("Enter the reverse of the number: ");
            long rev = scanner.nextLong(); //input reverse of number from user
            scanner.close();

            long result = powerMod(num, rev, 1000000007); //calculating result

            System.out.println("Result: " + result);
        }
    }




