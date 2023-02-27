package com.drdesperado.creational.abstractfactory.factoryImpl;

import com.drdesperado.creational.abstractfactory.aircraftImpl.TU;
import com.drdesperado.creational.abstractfactory.carImpl.Lada;
import com.drdesperado.creational.abstractfactory.factory.TransportFactory;
import com.drdesperado.creational.abstractfactory.transport.Aircraft;
import com.drdesperado.creational.abstractfactory.transport.Car;

public class RussianFactory implements TransportFactory {
    @Override
    public Car createCar() {
        return new Lada();
    }

    @Override
    public Aircraft createAircraft() {
        return new TU();
    }
}

