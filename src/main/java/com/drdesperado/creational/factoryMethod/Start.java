package com.drdesperado.creational.factoryMethod;

public class Start {
    public static void main(String[] args) {
        Car car = CarSelector.getInstance().getCar(RoadType.BRATSK);
        car.drive();
        car.stop();

        car = CarSelector.getInstance().getCar(RoadType.CHITA);
        car.drive();
        car.stop();

        car = CarSelector.getInstance().getCar(RoadType.MOSCOW);
        car.drive();
        car.stop();
    }
}
