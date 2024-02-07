package Feb6;
import java.util.*;
public class ReverseQueue
{ public static void reverse(Queue<Integer> queue)
{
            if (queue.isEmpty()) {
                return;
            }

            int front = queue.poll(); // Dequeue the front element

            reverse(queue); // Recursively reverse the remaining elements

            queue.add(front); // Enqueue the front element at the end
        }

        public static void main(String[] args) {
            Queue<Integer> queue = new LinkedList<>();

            queue.add(1); //adding elements
            queue.add(2);
            queue.add(3);
            queue.add(4);
            queue.add(5);

            System.out.println("Original Queue: " + queue);

            reverse(queue);

            System.out.println("Reversed Queue: " + queue);
        }
    }


