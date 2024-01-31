package Day3;
import java.util.Scanner;
public class SecondMinMax {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 9, 1, 7, 4, 10 };

        int secondMin = findSecondMinimum(arr);
        int secondMax = findSecondMaximum(arr);

        System.out.println("Second minimum: " + secondMin);
        System.out.println("Second maximum: " + secondMax);
    }

    public static int findSecondMinimum(int[] arr) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < min) {
                secondMin = min;
                min = num;
            } else if (num < secondMin && num != min) {
                secondMin = num;
            }
        }
        return secondMin;
    }

    public static int findSecondMaximum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }
        return secondMax;
    }
}
