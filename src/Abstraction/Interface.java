
package Abstraction;

interface A1 {
    void m1();
}

interface B1 {
    void m2();
}

class C implements A1, B1 {
    public void m1() {
        System.out.println("Hello from A");
    }

    public void m2() {
        System.out.println("Hello from B");
    }
}

public class Interface {
    public static void main(String[] args) {
        C obj = new C();
        obj.m1();
        obj.m2();
    }
}
