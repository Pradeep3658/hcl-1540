
package collection;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        list.set(1, 100);

        System.out.println("LinkedList: " + list);

        list.remove(2);

        System.out.println("After removal: " + list);
    }
}
