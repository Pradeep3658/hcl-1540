
package Abstraction;

abstract class A {
    void m1() {
        System.out.println("Hello");
    }

    abstract int m2();
}

class B extends A {
    @Override
    int m2() {
        return 10;
    }
}

public class Abstract_class {
    public static void main(String[] args) {
        B obj = new B();

        obj.m1();
        System.out.println(obj.m2());
    }
}
