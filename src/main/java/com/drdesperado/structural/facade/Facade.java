package com.drdesperado.structural.facade;

public class Facade {
    private final SubsystemTheFirst first;
    private final SubsystemTheSecond second;
    private final SubsystemTheThird third;

    public Facade(SubsystemTheFirst first, SubsystemTheSecond second, SubsystemTheThird third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public void facadeOperation() {
        first.operationA();
        second.operationB();
        third.operationC();
    }
}

class SubsystemTheFirst {
    void operationA() {
        System.out.println("Operation A");
    }
}

class SubsystemTheSecond {
    void operationB() {
        System.out.println("Operation B");
    }
}

class SubsystemTheThird {
    void operationC() {
        System.out.println("Operation C");
    }
}

class Test {
    public static void main(String[] args) {
        Facade facade = new Facade(new SubsystemTheFirst(), new SubsystemTheSecond(), new SubsystemTheThird());
        facade.facadeOperation();
    }
}
