package com.drdesperado.creational.abstractFactory.factory;

import com.drdesperado.creational.abstractFactory.transport.Aircraft;
import com.drdesperado.creational.abstractFactory.transport.Car;

public interface TransportFactory {
    Car createCar();
    Aircraft createAircraft();

}
