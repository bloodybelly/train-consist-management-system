package com.train.app;

import com.train.model.Coach;
import com.train.ds.CoachLinkedList;
import com.train.ds.CoachQueue;

import java.util.*;
import java.util.stream.Collectors;

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
        // 🚀 UC7: SORT COACHES
        // ===============================

        System.out.println("\n--- UC7: Sort Coaches by Capacity ---");

        List<Coach> coachList = train.toList();

        System.out.println("\nBefore Sorting:");
        for (Coach c : coachList) {
            System.out.println(c);
        }

        coachList.sort(Comparator.comparingInt(Coach::getCapacity));

        System.out.println("\nAfter Sorting (Ascending):");
        for (Coach c : coachList) {
            System.out.println(c);
        }

        // ===============================
        // 🚀 UC8: FILTER USING STREAM API
        // ===============================

        System.out.println("\n--- UC8: Filter Coaches with Capacity > 60 ---");

        List<Coach> filteredList = coachList.stream()
                .filter(c -> c.getCapacity() > 60)   // 🔥 core logic
                .collect(Collectors.toList());

        System.out.println("\nFiltered Coaches:");
        for (Coach c : filteredList) {
            System.out.println(c);
        }

        // ===============================
        // OPTIONAL: SHOW ORIGINAL LIST UNAFFECTED
        // ===============================

        System.out.println("\nOriginal List (Unchanged):");
        for (Coach c : coachList) {
            System.out.println(c);
        }
    }
}