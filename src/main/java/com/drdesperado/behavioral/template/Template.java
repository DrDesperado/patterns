package com.drdesperado.behavioral.template;


abstract public class Template {
    void templateMethod() {
        System.out.println(1);
        differ();
        System.out.println(3);
    }
    abstract void differ();
}

class A extends Template {
    @Override
    void differ() {
        System.out.println("A");
    }
}

class B extends Template {
    @Override
    void differ() {
        System.out.println("B");
    }
}

class Test {
    public static void main(String[] args) {
        Template templateA = new A();
        Template templateB = new B();

        templateA.templateMethod();
        templateB.templateMethod();
    }
}
