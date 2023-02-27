package com.drdesperado.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{
    private final List<Component> componentList = new ArrayList<>();

    public void addComponent(Component component) {
        componentList.add(component);
    }

    public void removeComponent(Component component) {
        componentList.remove(component);
    }

    @Override
    public void operation() {
        for (Component component : componentList) {
            component.operation();
        }
    }
}

interface Component {
    void operation();
}

class LeafA implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf A");
    }
}

class LeafB implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf B");
    }
}

class Test {
    public static void main(String[] args) {

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponent(new LeafA());
        composite1.addComponent(new LeafA());
        composite1.addComponent(new LeafB());

        composite2.addComponent(new LeafA());
        composite2.addComponent(new LeafB());
        composite2.addComponent(new LeafB());
        composite2.addComponent(new LeafA());

        composite.addComponent(composite1);
        composite.addComponent(composite2);
        composite.addComponent(new LeafB());

        composite.operation();
        System.out.println();

        composite.removeComponent(composite2);
        composite.operation();

    }
}
