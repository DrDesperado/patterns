package com.drdesperado.creational.factorymethod;

// фабрика по созданию автомобилей
public class CarSelector {

    //Singleton
    private static CarSelector instance;

    private CarSelector(){}

    public static CarSelector getInstance() {
        if (instance == null) {
            instance = new CarSelector();
        }
        return instance;
    }

    // фабричный метод, создающий нужный автомобиль
    public Car getCar(RoadType roadType) {
        Car car = null;
        switch (roadType) {
            case MOSCOW -> car = new Lada();
            case CHITA -> car = new Geep();
            case BRATSK -> car = new NewGeep();
        }
        return car;
    }


}
