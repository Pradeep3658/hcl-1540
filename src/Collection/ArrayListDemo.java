
package Collection;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        list.set(1, 20);
        list.set(4 , 50);

        System.out.println("Updated elements:");
        System.out.println(list.get(1));
        System.out.println(list.get(4));

        System.out.println("All elements:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
