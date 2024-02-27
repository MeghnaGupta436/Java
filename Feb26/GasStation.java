package Feb26;
import java.util.Scanner;

public class GasStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of the arrays
        System.out.print("Enter the size of the arrays: ");
        int n = scanner.nextInt();

        // Create arrays A and B
        int[] A = new int[n];
        int[] B = new int[n];

        // Input elements of array A
        System.out.println("Enter the elements of array A:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        // Input elements of array B
        System.out.println("Enter the elements of array B:");
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }

        // Find the minimum starting gas station's index
        int result = canCompleteCircuit(A, B);

        System.out.println("Minimum starting gas station's index: " + result);
    }

    public static int canCompleteCircuit(int[] A, int[] B) {
        int n = A.length;

        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int startingIndex = 0;

        for (int i = 0; i < n; i++) {
            totalGas += A[i];
            totalCost += B[i];
            tank += A[i] - B[i];
            if (tank < 0) {
                tank = 0;
                startingIndex = i + 1;
            }
        }

        if (totalGas < totalCost) {
            return -1;
        }

        return startingIndex < n ? startingIndex : -1;
    }
}

