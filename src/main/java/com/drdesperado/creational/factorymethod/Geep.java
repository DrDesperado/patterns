package com.drdesperado.creational.factorymethod;

public class Geep  implements Car{
    @Override
    public void drive() {
        System.out.println("Geep is driving");
    }

    @Override
    public void stop() {
        System.out.println("Geep has stopped");
    }
}

class NewGeep implements Car{

    @Override
    public void drive() {
        System.out.println("NewGeep is driving");
    }

    @Override
    public void stop() {
        System.out.println("NewGeep has stopped");
    }
}