package Feb6;
import java.util.*;
public class SortStackRecursion {
        public static void sortStack(Stack<Integer> stack) {
            if (stack.isEmpty() || stack.size() == 1) {
                return; // Base case: stack is already sorted
            }

            int temp = stack.pop(); //popping top element
            sortStack(stack);//recurtion
            insert(stack, temp); //insert popped element to right position
        }

        public static void insert(Stack<Integer> stack, int element) {
            if (stack.isEmpty() || stack.peek() < element) // base case
            {
                stack.push(element);
                return;
            }

            int temp = stack.pop(); //checking top element
            insert(stack, element);
            stack.push(temp);
        }

        public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();

            stack.push(5);// Example: 5, 2, 7, 1, 9
            stack.push(2);
            stack.push(7);
            stack.push(1);
            stack.push(9);

            System.out.println("Original Stack: " + stack);

            sortStack(stack);// Sort the stack

            System.out.println("Sorted Stack: " + stack);
        }
    }

