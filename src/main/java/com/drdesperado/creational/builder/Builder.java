package com.drdesperado.creational.builder;

public class Builder {
    public static void main(String[] args) {
        Person firstPerson = new Person.Builder("Vasya", 17)
                .setSalary(10000)
                .build();

        Person secondPerson = new Person.Builder("Tolik", 20)
                .build();

        System.out.println(firstPerson.toString());
        System.out.println(secondPerson.toString());
        System.out.println(firstPerson.getSalary());
    }
}


class Person{
    //required parameters
    private String name;
    private int age;
    //optional parameters
    private double salary;

    //class have only getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    //private constructor
    private Person(Builder builder) {
        this.age = builder.age;
        this.name = builder.name;
        this.salary = builder.salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //static nested class
    public static class Builder{
        private String name;
        private int age;
        private double salary;

        //constructor for required parameters
        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder setSalary(double salary) {
            this.salary = salary;
            return  this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
