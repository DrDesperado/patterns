package com.drdesperado.structural.bridge;

abstract class Bridge {
    //aggregation of interface
    private final Implementor implementor;
    public Bridge(Implementor implementor) {
        this.implementor = implementor;
    }
    abstract void someFunctionality();
    //using template pattern
    void useImplementation() {
        someFunctionality();
        implementor.implementation();
    }
}

class CaseTheFirst extends Bridge {

    public CaseTheFirst(Implementor implementor) {
        super(implementor);
    }

    @Override
    void someFunctionality() {
        System.out.println("First case:");
    }
}

class CaseTheSecond extends Bridge {

    public CaseTheSecond(Implementor implementor) {
        super(implementor);
    }

    @Override
    void someFunctionality() {
        System.out.println("Second case:");
    }
}



interface Implementor {
    void implementation();
}

class ConcreteImplementorA implements Implementor {
    @Override
    public void implementation() {
        System.out.println("Implementation of A");
    }
}

class ConcreteImplementorB implements Implementor {
    @Override
    public void implementation() {
        System.out.println("Implementation of B");
    }
}

class Test {
    public static void main(String[] args) {
        Bridge bridge = new CaseTheFirst(new ConcreteImplementorA());
        bridge.useImplementation();

        Bridge bridge1 = new CaseTheSecond(new ConcreteImplementorA());
        bridge1.useImplementation();

        Bridge bridge2 = new CaseTheFirst(new ConcreteImplementorB());
        bridge2.useImplementation();
    }
}


