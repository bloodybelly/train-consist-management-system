package com.train.model;

import com.train.exception.InvalidCapacityException;
import com.train.exception.CargoSafetyException;

public class Coach {

    private int id;
    private String type;
    private int capacity;
    private String shape;     // NEW (e.g., Rectangular, Cylindrical)
    private String cargo;     // NEW

    public Coach next;

    // Constructor (UC14 + UC15 ready)
    public Coach(int id, String type, int capacity, String shape)
            throws InvalidCapacityException {

        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than 0!");
        }

        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.shape = shape;
        this.cargo = "None";
        this.next = null;
    }

    // -------------------------------
    // UC15: Cargo Assignment
    // -------------------------------
    public void assignCargo(String cargoType) {

        // Unsafe rule
        if (cargoType.equalsIgnoreCase("Petroleum")
                && shape.equalsIgnoreCase("Rectangular")) {

            throw new CargoSafetyException(
                    "Unsafe! Petroleum cannot be stored in Rectangular bogie."
            );
        }

        this.cargo = cargoType;
        System.out.println("Cargo assigned: " + cargoType + " to Coach " + id);
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getShape() {
        return shape;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Coach ID: " + id +
                ", Type: " + type +
                ", Capacity: " + capacity +
                ", Shape: " + shape +
                ", Cargo: " + cargo;
    }
}