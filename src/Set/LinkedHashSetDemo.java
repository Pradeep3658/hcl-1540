
package Set;

import java.util.Set;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {

        // Create a LinkedHashSet
        Set<Integer> s = new LinkedHashSet<>();

        // Add elements
        s.add(10);
        s.add(20);
        s.add(30);
        s.add(40);
        s.add(20);

        // Print Set
        System.out.println(s);

        // Check element
        System.out.println(s.contains(20));

        // Remove element
        s.remove(30);
        System.out.println(s);

        // Print size
        System.out.println(s.size());

        // Check whether Set is empty
        System.out.println(s.isEmpty());
    }
}
