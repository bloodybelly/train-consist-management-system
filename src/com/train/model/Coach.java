package com.train.model;

public class Coach {
    private int coachId;
    private String coachType; // Sleeper, AC, General
    private int capacity;

    public Coach(int coachId, String coachType, int capacity) {
        this.coachId = coachId;
        this.coachType = coachType;
        this.capacity = capacity;
    }

    public int getCoachId() {
        return coachId;
    }

    public String getCoachType() {
        return coachType;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Coach ID: " + coachId +
                ", Type: " + coachType +
                ", Capacity: " + capacity;
    }
}