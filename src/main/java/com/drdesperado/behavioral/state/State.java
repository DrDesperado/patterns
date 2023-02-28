package com.drdesperado.behavioral.state;

public interface State {
    void someMethod();
}

class Context{
    private State currentState;

    public void setCurrentState(State s){
        currentState = s;
    }

    public void nextState() {
        if (currentState instanceof ConcreteStateA) {
            setCurrentState(new ConcreteStateB());
        }
        else if (currentState instanceof ConcreteStateB) {
            setCurrentState(new ConcreteStateA());
        }
    }

    public void someMethod() {
        currentState.someMethod();
    }
}

class ConcreteStateA implements State{
    @Override
    public void someMethod() {
        System.out.println("Concrete State A");
    }
}

class ConcreteStateB implements State{
    @Override
    public void someMethod() {
        System.out.println("Concrete State B");
    }
}

class Test {
    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(new ConcreteStateA());
        context.someMethod();
        context.nextState();
        context.someMethod();

        context.nextState();
        context.nextState();
        context.someMethod();
    }
}

