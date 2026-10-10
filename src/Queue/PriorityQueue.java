
package collectionframework;

import java.util.Queue;

public class PriorityQueue {
    public static void main(String[] args) {

        // Create a PriorityQueue
        Queue<Integer> q = new java.util.PriorityQueue<>();

        // Add elements
        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);

        // Print Queue
        System.out.println(q);

        // Remove smallest element
        System.out.println(q.poll());

        // Show smallest element
        System.out.println(q.peek());

        // Print size
        System.out.println(q.size());

        // Check if empty
        System.out.println(q.isEmpty());

        // Remove next smallest element
        System.out.println(q.remove());

        // Print updated Queue
        System.out.println(q);
    }
}
