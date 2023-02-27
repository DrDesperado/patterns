package com.drdesperado.creational.singleton;

public class Singleton {

    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    private Singleton() {
    }

    public void print() {
        System.out.println(this);
    }
}


class Test {
    public static void main(String[] args) {
        Singleton.getInstance().print();
        Singleton.getInstance().print();
    }
}