package com.train.model;

import com.train.exception.InvalidCapacityException;

public class Coach {

    private int id;
    private String type;
    private int capacity;

    public Coach next; // for LinkedList

    // Constructor with validation
    public Coach(int id, String type, int capacity) throws InvalidCapacityException {

        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than 0!");
        }

        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.next = null;
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

    @Override
    public String toString() {
        return "Coach ID: " + id + ", Type: " + type + ", Capacity: " + capacity;
    }
}