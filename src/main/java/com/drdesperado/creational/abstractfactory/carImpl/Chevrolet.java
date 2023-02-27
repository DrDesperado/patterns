package com.drdesperado.creational.abstractfactory.carImpl;

import com.drdesperado.creational.abstractfactory.transport.Car;

public class Chevrolet implements Car {

    @Override
    public void drive() {
        System.out.println("Chevrolet is driving");
    }

    @Override
    public void stop() {
        System.out.println("Chevrolet has stopped");
    }
}
