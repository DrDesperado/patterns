package com.drdesperado.creational.abstractfactory;

import com.drdesperado.creational.abstractfactory.factory.TransportFactory;
import com.drdesperado.creational.abstractfactory.factoryImpl.RussianFactory;
import com.drdesperado.creational.abstractfactory.factoryImpl.USAFactory;
import com.drdesperado.creational.abstractfactory.transport.Aircraft;
import com.drdesperado.creational.abstractfactory.transport.Car;

public class Start {
    private static TransportFactory transportFactory;
    public static void main(String[] args) {

        if (true) {
            transportFactory = new RussianFactory();
        } else {
            transportFactory = new USAFactory();
        }

        Car car = transportFactory.createCar();
        Aircraft aircraft = transportFactory.createAircraft();

        car.drive();
        car.stop();

        aircraft.fly();


    }
}
