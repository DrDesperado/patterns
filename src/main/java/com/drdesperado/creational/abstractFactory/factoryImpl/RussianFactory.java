package com.drdesperado.creational.abstractFactory.factoryImpl;

import com.drdesperado.creational.abstractFactory.aircraftImpl.TU;
import com.drdesperado.creational.abstractFactory.carImpl.Lada;
import com.drdesperado.creational.abstractFactory.factory.TransportFactory;
import com.drdesperado.creational.abstractFactory.transport.Aircraft;
import com.drdesperado.creational.abstractFactory.transport.Car;

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

