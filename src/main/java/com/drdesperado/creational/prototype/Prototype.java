package com.drdesperado.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle vehicle = new Vehicle();
        vehicle.insertData();

        Vehicle newVehicle = (Vehicle) vehicle.clone();
        newVehicle.getVehicleList().add("Lada Vesta");

        System.out.println(vehicle.getVehicleList());
        System.out.println(newVehicle.getVehicleList());
    }
}


class Vehicle implements Cloneable {
    private List<String> vehicleList;

    public Vehicle() {
        this.vehicleList = new ArrayList<>();
    }

    public Vehicle(List<String> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public void insertData() {
        vehicleList.add("Lada Priora");
        vehicleList.add("Audi A4");
        vehicleList.add("Nissan Expert");
        vehicleList.add("UAZ Patriot");
        vehicleList.add("Volga");
    }

    public List<String> getVehicleList() {
        return vehicleList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<>();

        for (String s : this.getVehicleList()) {
            tempList.add(s);
        }

        return new Vehicle(tempList);
    }
}
