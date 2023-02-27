package com.drdesperado.creational.abstractFactory.aircraftImpl;

import com.drdesperado.creational.abstractFactory.transport.Aircraft;

public class Boeing implements Aircraft {

    @Override
    public void fly() {
        System.out.println("Boeing is flying");
    }
}
