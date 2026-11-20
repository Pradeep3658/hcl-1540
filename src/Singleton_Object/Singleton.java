
package Singleton_Object;

public class Singleton {

    private static Singleton obj = new Singleton();

    private Singleton() {
        System.out.println("Object Created");
    }

    public static Singleton getInstance() {
        return obj;
    }
}
