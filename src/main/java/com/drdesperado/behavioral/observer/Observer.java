package com.drdesperado.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public interface Observer {
    void handleEvent();
}

interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}

class TheFirstObserver implements Observer {
    @Override
    public void handleEvent() {
        System.out.println("Action of the First observer");
    }
}

class TheSecondObserver implements Observer {

    @Override
    public void handleEvent() {
        System.out.println("Action of the Second observer");
    }
}

class ConcreteObservable implements Observable {

    private final List<Observer> observerList = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observerList) {
            o.handleEvent();
        }
    }
}

class Test {
    public static void main(String[] args) {
        ConcreteObservable concreteObservable = new ConcreteObservable();
        concreteObservable.addObserver(new TheFirstObserver());
        concreteObservable.addObserver(new TheSecondObserver());
        concreteObservable.addObserver(new TheFirstObserver());
        concreteObservable.notifyObserver();
    }
}