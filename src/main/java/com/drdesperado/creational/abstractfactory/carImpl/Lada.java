package com.drdesperado.creational.abstractfactory.carImpl;

import com.drdesperado.creational.abstractfactory.transport.Car;

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

