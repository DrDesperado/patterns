package com.drdesperado.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public interface Mediator {
    //broadcast Event
    void sendMessage(String message, User user);
}

//Concrete Mediator
class TextChat implements Mediator{
    private User admin;
    private List<User> userList = new ArrayList<>();

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        admin.getMessage(message);

        for (User u : userList) {
            u.getMessage(message);
        }
    }
}


//Client
interface User {
    void sendMessage(String message);
    void getMessage(String message);
}

//Concrete Aggregate
class Admin implements User{
    private final Mediator mediator;

    public Admin(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Admin gets a message: " + message);
    }
}

//Concrete Aggregate
class SimpleUser implements User{
    private final Mediator mediator;

    public SimpleUser(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("User gets a message: " + message);
    }
}

class Test {
    public static void main(String[] args) {
        TextChat textChat = new TextChat();

        User admin = new Admin(textChat);
        User u1 = new SimpleUser(textChat);
        User u2 = new SimpleUser(textChat);

        textChat.setAdmin(admin);
        textChat.addUser(u1);
        textChat.addUser(u2);

        u1.sendMessage("hi, user");
        admin.sendMessage("hi, admin");
    }
}


