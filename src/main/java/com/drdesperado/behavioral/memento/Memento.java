package com.drdesperado.behavioral.memento;

public class Memento{
    private final String level;
    private final int ms;

    public Memento(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public String getLevel() {
        return level;
    }

    public int getMs() {
        return ms;
    }
}

class Originator {
    //State
    private String level;
    private int ms;

    public void set(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public void setMemento(Memento memento)  {
        level = memento.getLevel();
        ms = memento.getMs();
    }
    public Memento createMemento() {
        return new Memento(level, ms);
    }

    @Override
    public String toString() {
        return "Originator{" +
                "level='" + level + '\'' +
                ", ms=" + ms +
                '}';
    }
}

class CareTaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

class Test {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.set("LVL 1", 20000);
        System.out.println(originator);

        CareTaker careTaker = new CareTaker();
        careTaker.setMemento(originator.createMemento());

        originator.set("LVL 2", 600000);
        System.out.println(originator);

        originator.setMemento(careTaker.getMemento());
        System.out.println(originator);

    }
}

