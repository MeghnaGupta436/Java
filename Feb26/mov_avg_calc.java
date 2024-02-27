package Feb26;
import java.util.Arrays;
import java.util.Scanner;

public class mov_avg_calc {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the size ");
        int size = sc.nextInt();
        System.out.println("Enter the elements ");
//      int[] vect = {1, 2, 3, 4};
        int[] vect=new int[size];
        for(int i=0;i<size;i++){
            vect[i]=sc.nextInt();
        }
        System.out.println("Enter the window size");
        int windowSize =sc.nextInt();
        int[] result = calc_mov_avg(size, vect, windowSize);
        int n = result.length;
        System.out.println("n = " + n);
        System.out.println("result = " + Arrays.toString(result));
    }
    public static int[] calc_mov_avg(int size, int[] vect, int windowSize) {
        int n = size - windowSize + 1;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int windowSum = 0;
            for (int j = i; j < i + windowSize; j++) {
                windowSum += vect[j];
            }
            double windowAvg = (double) windowSum / windowSize;
            result[i] = (int) Math.round(windowAvg);
        }
        return result;
    }
}
