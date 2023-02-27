package com.drdesperado.creational.abstractfactory.factory;

import com.drdesperado.creational.abstractfactory.transport.Aircraft;
import com.drdesperado.creational.abstractfactory.transport.Car;

public interface TransportFactory {
    Car createCar();
    Aircraft createAircraft();

}
