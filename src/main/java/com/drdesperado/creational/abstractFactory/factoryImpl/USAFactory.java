package com.drdesperado.creational.abstractFactory.factoryImpl;

import com.drdesperado.creational.abstractFactory.aircraftImpl.Boeing;
import com.drdesperado.creational.abstractFactory.carImpl.Chevrolet;
import com.drdesperado.creational.abstractFactory.factory.TransportFactory;
import com.drdesperado.creational.abstractFactory.transport.Aircraft;
import com.drdesperado.creational.abstractFactory.transport.Car;

public class USAFactory implements TransportFactory {

    @Override
    public Car createCar() {
        return new Chevrolet();
    }

    @Override
    public Aircraft createAircraft() {
        return new Boeing();
    }
}
