package com.train.app;

import com.train.model.Coach;
import com.train.ds.CoachLinkedList;
import com.train.ds.CoachQueue;
import com.train.exception.InvalidCapacityException;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        CoachLinkedList train = new CoachLinkedList();
        CoachQueue yard = new CoachQueue();

        System.out.println("\n--- UC14: Capacity Validation ---");

        try {
            // VALID coaches
            yard.enqueue(new Coach(201, "Sleeper", 72));
            yard.enqueue(new Coach(202, "AC", 50));

            // ❌ INVALID coach (will throw exception)
            yard.enqueue(new Coach(203, "General", -10));

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Continue program safely
        System.out.println("\nRemaining valid coaches in yard:");
        yard.displayQueue();

        // Add to train
        train.addCoach(yard.dequeue());
        train.addCoach(yard.dequeue());

        System.out.println("\nTrain:");
        train.display();
    }
}