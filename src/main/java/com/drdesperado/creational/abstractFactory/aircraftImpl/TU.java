package com.drdesperado.creational.abstractFactory.aircraftImpl;

import com.drdesperado.creational.abstractFactory.transport.Aircraft;

public class TU implements Aircraft {
    @Override
    public void fly() {
        System.out.println("TU is flying");
    }
}

