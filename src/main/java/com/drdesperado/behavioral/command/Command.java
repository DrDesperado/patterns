package com.drdesperado.behavioral.command;

public interface Command {
    void execute();
}

//Receiver
class Computer{
    void start() {
        System.out.println("Start");
    }
    void stop() {
        System.out.println("Stop");
    }

    void reset() {
        System.out.println("Reset");
    }
}

//ConcreteCommand 1
class StartCommand implements Command {
    private final Computer computer;

    public StartCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.start();
    }
}

class StopCommand implements Command {
    private final Computer computer;

    public StopCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.stop();
    }
}

class ResetCommand implements Command {
    private final Computer computer;

    public ResetCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.reset();
    }
}

//Invoker
class User {
    private final Command start;
    private final Command stop;
    private final Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    public void startComputer() {
        start.execute();
    }
    public void stopComputer() {
        stop.execute();
    }
    public void resetComputer() {
        reset.execute();
    }
}

class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User(new StartCommand(computer), new StopCommand(computer), new ResetCommand(computer));

        user.startComputer();
        user.resetComputer();
        user.stopComputer();

    }
}
