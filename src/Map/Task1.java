
package Collections_Framework.Task1;

import java.util.ArrayList;

class STUDENT {
    int roll, age;
    String name;
    double marks;

    // Constructor
    STUDENT(int roll, double marks, int age, String name) {
        this.roll = roll;
        this.marks = marks;
        this.age = age;
        this.name = name;
    }
}

public class Task1 {
    public static void main(String[] args) {

        ArrayList<STUDENT> list = new ArrayList<>();

        // Add student details
        list.add(new STUDENT(1, 35, 20, "Aman Y"));
        list.add(new STUDENT(2, 45, 21, "Aman V"));
        list.add(new STUDENT(3, 55, 22, "Aman S"));
        list.add(new STUDENT(4, 65, 19, "Ankit P"));
        list.add(new STUDENT(5, 75, 18, "Ankit M"));
        list.add(new STUDENT(6, 85, 17, "Ankit Y"));
        list.add(new STUDENT(7, 95, 24, "Adarsh"));
        list.add(new STUDENT(8, 25, 22, "Pradeep"));
        list.add(new STUDENT(9, 15, 25, "Prince"));
        list.add(new STUDENT(10, 5, 21, "Ujwal"));

        // Sort by marks using Lambda Expression
        list.sort((a, b) -> Double.compare(a.marks, b.marks));

        // Print sorted student details
        list.forEach(s -> System.out.println(
                "ROLL NO=" + s.roll +
                        " Marks=" + s.marks +
                        " AGE=" + s.age +
                        " Name=" + s.name
        ));
    }
}
