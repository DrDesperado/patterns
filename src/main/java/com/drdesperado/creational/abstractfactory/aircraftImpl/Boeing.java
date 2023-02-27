package com.drdesperado.creational.abstractfactory.aircraftImpl;

import com.drdesperado.creational.abstractfactory.transport.Aircraft;

public class Boeing implements Aircraft {

    @Override
    public void fly() {
        System.out.println("Boeing is flying");
    }
}
