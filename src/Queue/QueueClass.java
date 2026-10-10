
package collectionframework;

import java.util.Queue;
import java.util.LinkedList;

public class QueueClass {
    public static void main(String[] args) {

        // Create a Queue
        Queue<Integer> q = new LinkedList<>();

        // Add elements to the Queue
        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);

        // Display Queue
        System.out.println("Queue: " + q);

        // Remove the first element
        System.out.println("Removed: " + q.poll());

        // Display first element without removing
        System.out.println("Front: " + q.peek());

        // Display updated Queue
        System.out.println("Updated Queue: " + q);
    }
}
