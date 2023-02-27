package com.drdesperado.structural.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyWeight {
    private static final Map<String, Car> carMap = new HashMap<>();

    public Car getCar(String name) {
        Car car = carMap.get(name);
        if (car == null) {
            switch (name) {
                case "Chevrolet" -> car = new Chevrolet();
                case "BMW" -> car = new BMW();
                case "Renault" -> car = new Renault();
            }
            carMap.put(name, car);
        }
        return car;
    }
}

interface Car {
    void build();
}

class Chevrolet implements Car{
    @Override
    public void build() {
        System.out.println("Chevrolet");
    }
}

class BMW implements Car{
    @Override
    public void build() {
        System.out.println("BMW");
    }
}

class Renault implements Car{
    @Override
    public void build() {
        System.out.println("Renault");
    }
}

class Test {
    public static void main(String[] args) {
        FlyWeight flyWeight = new FlyWeight();
        List<Car> carList = new ArrayList<>();

        carList.add(flyWeight.getCar("Chevrolet"));
        carList.add(flyWeight.getCar("Renault"));
        carList.add(flyWeight.getCar("Renault"));
        carList.add(flyWeight.getCar("BMW"));
        carList.add(flyWeight.getCar("Chevrolet"));
        carList.add(flyWeight.getCar("Renault"));

        for (Car car : carList) {
            car.build();
        }
    }
}
