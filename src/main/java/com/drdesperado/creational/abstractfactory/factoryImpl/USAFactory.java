package com.drdesperado.creational.abstractfactory.factoryImpl;

import com.drdesperado.creational.abstractfactory.aircraftImpl.Boeing;
import com.drdesperado.creational.abstractfactory.carImpl.Chevrolet;
import com.drdesperado.creational.abstractfactory.factory.TransportFactory;
import com.drdesperado.creational.abstractfactory.transport.Aircraft;
import com.drdesperado.creational.abstractfactory.transport.Car;

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
