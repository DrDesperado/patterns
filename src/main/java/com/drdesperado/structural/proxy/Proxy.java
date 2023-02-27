package com.drdesperado.structural.proxy;

public class Proxy implements Image{
    private RealImage realImage;
    private final String file;

    public Proxy(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(file);
        }
        realImage.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image{
    private final String file;
    public RealImage(String file) {
        this.file = file;
        load();
    }

    private void load() {
        System.out.println("load " + file);
    }

    @Override
    public void display() {
        System.out.println("display " + file);
    }
}

class Test {
    public static void main(String[] args) {
        Image image = new Proxy("image.png");
        image.display();
    }
}

