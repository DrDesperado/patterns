package com.drdesperado.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public interface Visitor {
    void visit(FuelTankElement fuelTankElement);
    void visit(EngineElement engineElement);
    void visit(BikeElement bikeElement);
}

class PartsChecker implements Visitor{
    @Override
    public void visit(FuelTankElement fuelTankElement) {
        System.out.println( "Checking whether there is fuel in fuel tank");
    }

    @Override
    public void visit(EngineElement engineElement) {
        System.out.println( "Checking whether ignition switch is on");
    }

    @Override
    public void visit(BikeElement bikeElement) {
        System.out.println("Going to the bike");
    }
}

class PartsOperator implements Visitor {
    @Override
    public void visit(FuelTankElement fuelTankElement) {
        System.out.println("Releasing fuel from fuel tank to Engine");
    }

    @Override
    public void visit(EngineElement engineElement) {
        System.out.println("Accepting fuel from fuel tank and running engine");
    }

    @Override
    public void visit(BikeElement bikeElement) {
        System.out.println("Now going to start bike");
    }
}

interface Element {
    void accept(Visitor visitor);
}

class FuelTankElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class EngineElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class BikeElement implements Element{
    private List<Element> elementList = new ArrayList<>();

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element element : elementList) {
            element.accept(visitor);
        }
    }

    public void addBikePart(Element part) {
        elementList.add(part);
    }
}

class Test {
    public static void main(String[] args) {
        BikeElement bikeElement = new BikeElement();
        bikeElement.addBikePart(new FuelTankElement());
        bikeElement.addBikePart(new EngineElement());

        bikeElement.accept(new PartsChecker());
        bikeElement.accept(new PartsOperator());
    }
}
