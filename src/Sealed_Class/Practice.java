package practice;

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

public class Practice {
    public static void main(String[] args) {

        System.out.println("Vehicle 1: Car");
        Car myCar = new Car();
        myCar.start();
        myCar.playMusic();

        System.out.println();

        System.out.println("Vehicle 2: Bike");
        Bike myBike = new Bike();
        myBike.start();
        myBike.doWheelie();
    }
}