package com.drdesperado.behavioral.chainofresponsibility;

//Handler
abstract public class LoggerHandler{
    protected final Level priority;
    protected LoggerHandler next;

    public LoggerHandler(Level priority) {
        this.priority = priority;
    }

    void setNext(LoggerHandler next){
        this.next = next;
    }
    abstract void writeMessage(String message, Level level);
}

class SMSLogger extends LoggerHandler {
    public SMSLogger(Level priority) {
        super(priority);
    }

    @Override
    public void writeMessage(String message, Level level) {
        if (level.getId() <= priority.getId()) {
            System.out.println("SMS: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}

class FileLogger extends LoggerHandler {

    public FileLogger(Level priority) {
        super(priority);
    }
    @Override
    public void writeMessage(String message, Level level) {
        if (level.getId() <= priority.getId()) {
            System.out.println("File: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}

class EmailLogger extends LoggerHandler {
    public EmailLogger(Level priority) {
        super(priority);
    }

    @Override
    public void writeMessage(String message, Level level) {
        if (level.getId() <= priority.getId()) {
            System.out.println("Email: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}

enum Level {
    ERROR(1), DEBUG(2), INFO(3);
    private final int id;

    Level(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class Test {
    public static void main(String[] args) {
        LoggerHandler logger1 = new SMSLogger(Level.ERROR);
        LoggerHandler logger2 = new FileLogger(Level.DEBUG);
        LoggerHandler logger3 = new EmailLogger(Level.INFO);

        logger1.setNext(logger2);
        logger2.setNext(logger3);

        logger1.writeMessage("OK", Level.INFO);
        logger1.writeMessage("DEBUG", Level.DEBUG);
        logger1.writeMessage("ERROR", Level.ERROR);
    }
}
