package com.drdesperado.creational.abstractFactory;

import com.drdesperado.creational.abstractFactory.factory.TransportFactory;
import com.drdesperado.creational.abstractFactory.factoryImpl.RussianFactory;
import com.drdesperado.creational.abstractFactory.factoryImpl.USAFactory;
import com.drdesperado.creational.abstractFactory.transport.Aircraft;
import com.drdesperado.creational.abstractFactory.transport.Car;

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
