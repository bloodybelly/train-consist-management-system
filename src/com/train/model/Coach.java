package com.train.model;

public class Coach {

    private int id;
    private String type;
    private int capacity;

    public Coach next; // for LinkedList

    public Coach(int id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.next = null;
    }

    // Getters (REQUIRED for UC7)
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