package com.drdesperado.creational.abstractFactory.carImpl;

import com.drdesperado.creational.abstractFactory.transport.Car;

public class Lada implements Car {
    @Override
    public void drive() {
        System.out.println("Lada is driving");
    }

    @Override
    public void stop() {
        System.out.println("Lada has stopped");
    }
}

