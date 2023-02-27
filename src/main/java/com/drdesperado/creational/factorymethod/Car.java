package com.drdesperado.creational.factorymethod;

public interface Car {
    void drive();
    void stop();

}

class Lada implements Car {

    @Override
    public void drive() {
        System.out.println("Lada is driving");
    }

    @Override
    public void stop() {
        System.out.println("Lada has stopped");
    }
}

enum RoadType {
    MOSCOW,
    CHITA,
    BRATSK

}