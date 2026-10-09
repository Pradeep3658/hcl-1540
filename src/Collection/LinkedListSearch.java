
package collection;

import java.util.LinkedList;

public class LinkedListSearch {
    public static void main(String[] args) {

        // Create a LinkedList
        LinkedList<String> fruits = new LinkedList<>();

        // Add elements to the list
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        // Display the list
        System.out.println("Fruits: " + fruits);

        // Search the first occurrence of Mango
        System.out.println("Index of Mango: " + fruits.indexOf("Mango"));

        // Search the last occurrence of Mango
        System.out.println("Last Index of Mango: " + fruits.lastIndexOf("Mango"));

        // Check whether Apple exists
        System.out.println("Contains Apple: " + fruits.contains("Apple"));

        // Search an element that does not exist
        System.out.println("Index of Grapes: " + fruits.indexOf("Grapes"));
    }
}
