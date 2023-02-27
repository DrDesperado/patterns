package com.drdesperado.creational.abstractfactory.aircraftImpl;

import com.drdesperado.creational.abstractfactory.transport.Aircraft;

public class TU implements Aircraft {
    @Override
    public void fly() {
        System.out.println("TU is flying");
    }
}

