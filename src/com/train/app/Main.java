package com.train.app;

import com.train.model.Coach;
import com.train.ds.CoachLinkedList;
import com.train.ds.CoachQueue;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        CoachLinkedList train = new CoachLinkedList();
        CoachQueue yard = new CoachQueue();

        // ===============================
        // EXISTING FUNCTIONALITY
        // ===============================

        yard.enqueue(new Coach(201, "Sleeper", 72));
        yard.enqueue(new Coach(202, "AC", 50));
        yard.enqueue(new Coach(203, "General", 100));

        System.out.println("Yard Queue:");
        yard.displayQueue();

        train.addCoach(yard.dequeue());
        train.addCoach(yard.dequeue());
        train.addCoach(yard.dequeue());

        System.out.println("\nTrain after attaching from yard:");
        train.display();

        // ===============================
        // 🚀 UC7: SORT TRAIN COACHES
        // ===============================

        System.out.println("\n--- UC7: Sort Existing Train Coaches ---");

        // Step 1: Convert LinkedList → List
        List<Coach> coachList = train.toList();

        // Step 2: Before sorting
        System.out.println("\nBefore Sorting:");
        for (Coach c : coachList) {
            System.out.println(c);
        }

        // Step 3: Sort using Comparator (ASC)
        coachList.sort(Comparator.comparingInt(Coach::getCapacity));

        System.out.println("\nAfter Sorting (Ascending Capacity):");
        for (Coach c : coachList) {
            System.out.println(c);
        }

        // Step 4: Sort DESC
        coachList.sort(Comparator.comparingInt(Coach::getCapacity).reversed());

        System.out.println("\nAfter Sorting (Descending Capacity):");
        for (Coach c : coachList) {
            System.out.println(c);
        }
    }
}