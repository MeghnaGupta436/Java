package Feb6;
import java.util.Scanner;
public class LongestSubsequence {
    public static int FindlongestSubsequence(int[] nums, int prevIndex, int currentIndex) {
        if (currentIndex == nums.length)//base case
             {
            return 0;
        }
        //recursion
        int excludeCurrent = FindlongestSubsequence(nums, prevIndex, currentIndex + 1);
        int includeCurrent = 0;
        if (prevIndex < 0 || nums[currentIndex] > nums[prevIndex]) {
            includeCurrent = 1 + FindlongestSubsequence(nums, currentIndex, currentIndex + 1);
        }

        return Math.max(includeCurrent, excludeCurrent);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt(); //input size
        int[] nums = new int[size]; //creating array

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt(); //input array
        }

        scanner.close();

        int length = FindlongestSubsequence(nums, -1, 0);//function calling
        System.out.println("Length of the longest increasing subsequence: " + length);//display
    }
}
