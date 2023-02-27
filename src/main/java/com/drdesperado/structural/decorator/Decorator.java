package com.drdesperado.structural.decorator;

abstract class Decorator implements Component{
    private final Component component;
    public Decorator(Component component) {
        this.component = component;
    }

    void operationOfInterface() {
        component.operation();
    }

}

class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.print("[");
        operationOfInterface();
        System.out.print("]");
    }
}

interface Component {
    void operation();
}

class ConcreteComponent implements Component{
    private final String text;

    public ConcreteComponent(String text) {
        this.text = text;
    }

    @Override
    public void operation() {
        System.out.print(text);
    }
}

class Test {
    public static void main(String[] args) {
        Decorator decorator = new ConcreteDecorator(new ConcreteComponent("Hello"));
        decorator.operation();
    }
}