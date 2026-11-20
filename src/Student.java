public class Student {

    String name;
    int rollNo;

    // Constructor 1
    Student() {
        this("Unknown", 0);
    }

    // Constructor 2
    Student(String name) {
        this(name, 0);
    }

    // Constructor 3
    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;

        System.out.println("Name: " + this.name);
        System.out.println("Roll No: " + this.rollNo);
    }

    void study() {
        System.out.println(this.name + " is studying");
    }
}