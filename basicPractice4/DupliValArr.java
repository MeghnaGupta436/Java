public class DupliValArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5, 6, 1};

        System.out.println("Duplicate values in the array:");
        findDuplicates(arr);
    }

    public static void findDuplicates(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j) {
                    System.out.println(arr[i]);
                }
            }
        }
    }
}

