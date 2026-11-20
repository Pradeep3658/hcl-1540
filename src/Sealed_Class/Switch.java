
package Sealed_Class;

sealed class Vehicle permits Car, Bike {
    public void start() {
        System.out.println("Engine is running");
    }
}

final class Car extends Vehicle {
    public void playMusic() {
        System.out.println("Playing FM Radio");
    }
}

final class Bike extends Vehicle {
    public void doWheelie() {
        System.out.println("Doing a wheelie");
    }
}

public class Switch {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        Vehicle myBike = new Bike();

        System.out.println("First vehicle test:");
        testVehicle(myCar);

        System.out.println();

        System.out.println("Second vehicle test:");
        testVehicle(myBike);
    }




    static void testVehicle(Vehicle v) {
        if (v == null) {
            System.out.println("Vehicle is null");
            return;
        }

        switch (v) {
            case Car c -> c.playMusic();
            case Bike b -> b.doWheelie();
            default -> System.out.println("Unknown vehicle");
        }
    }


}
