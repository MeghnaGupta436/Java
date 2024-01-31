import java.util.Arrays;

public class Merge2Array{
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};

        int[] mergedArray = mergeArrays(arr1, arr2);

        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        System.out.println("Merged Array: " + Arrays.toString(mergedArray));
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];

        int index = 0;
        for (int i = 0; i < arr1.length; i++) {
            mergedArray[index++] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            mergedArray[index++] = arr2[i];
        }

        return mergedArray;
    }
}
