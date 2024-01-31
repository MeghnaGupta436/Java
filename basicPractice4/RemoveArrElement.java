package Day3;
import java.util.Scanner;
import java.util.Arrays;


    public class RemoveArrElement {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            int elementToRemove = 3;

            System.out.println("Original Array: " + Arrays.toString(arr));

            arr = removeElement(arr, elementToRemove);

            System.out.println("Array after removing " + elementToRemove + ": " + Arrays.toString(arr));
        }

        public static int[] removeElement(int[] arr, int elementToRemove) {
            int index = -1;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == elementToRemove) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {

                int[] newArr = new int[arr.length - 1];

                for (int i = 0, j = 0; i < arr.length; i++) {
                    if (i != index) {
                        newArr[j++] = arr[i];
                    }
                }
                return newArr;
            } else {

                return arr;
            }
        }
    }


