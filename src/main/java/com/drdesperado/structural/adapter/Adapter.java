package com.drdesperado.structural.adapter;

//We want to adapt the existing class with the interface Adaptee to match the interface Target
public class Adapter implements Target{
    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        //reference to the object we are adapting
        this.adaptee = adaptee;
    }

    @Override
    public void firstMethodOfTarget() {
        adaptee.firstMethodOfAdaptee();
    }

    @Override
    public void secondMethodOfTarget() {
        adaptee.secondMethodOfAdaptee();
    }
}


interface Adaptee {
    void firstMethodOfAdaptee();
    void secondMethodOfAdaptee();
}

//we have the class with interface Adaptee
class AdapteeImpl implements Adaptee {
    @Override
    public void firstMethodOfAdaptee() {
        System.out.println("implementation of first method of class Adaptee");
    }

    @Override
    public void secondMethodOfAdaptee() {
        System.out.println("implementation of second method of class Adaptee");
    }
}

//We want to adapt to the interface Target
interface Target {
    void firstMethodOfTarget();
    void secondMethodOfTarget();
}

class TargetImpl implements Target {

    @Override
    public void firstMethodOfTarget() {
        System.out.println("implementation of first method of class Target");
    }

    @Override
    public void secondMethodOfTarget() {
        System.out.println("implementation of second method of class Target");
    }
}

class Test {
    public static void main(String[] args) {
        Adaptee adaptee = new AdapteeImpl();
        Target target = new TargetImpl();
        Target adapter = new Adapter(adaptee);

        adaptee.firstMethodOfAdaptee();
        adaptee.secondMethodOfAdaptee();

        target.firstMethodOfTarget();
        target.secondMethodOfTarget();

        adapter.firstMethodOfTarget();
        adapter.secondMethodOfTarget();
    }
}