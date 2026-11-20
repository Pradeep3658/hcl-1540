
package collection;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListForward {
    public static void main(String[] args) {

        // Create a LinkedList
        LinkedList<String> fruits = new LinkedList<>();

        // Add elements to the LinkedList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Guava");
        fruits.add("Watermelon");
        fruits.add("Pineapple");
        fruits.add("Orange");

        // Display original list
        System.out.println("Original List: " + fruits);

        // Add element at the beginning
        fruits.addFirst("Grapes");

        // Add element at the end
        fruits.addLast("Kiwi");

        // Display list after adding elements
        System.out.println("After Adding: " + fruits);

        // Remove a specific element
        fruits.remove("Banana");

        // Remove the first element
        fruits.removeFirst();

        // Remove the last element
        fruits.removeLast();

        // Display list after removing elements
        System.out.println("After Removing: " + fruits);

        // Access the first element
        System.out.println("First Fruit: " + fruits.getFirst());

        // Access the last element
        System.out.println("Last Fruit: " + fruits.getLast());

        // Forward movement using ListIterator
        System.out.println("Forward Movement:");

        ListIterator<String> itr = fruits.listIterator();

        // Traverse and print all elements
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
