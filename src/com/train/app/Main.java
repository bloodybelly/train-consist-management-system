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
        yard.enqueue(new Coach(204, "AC", 60)); // extra for grouping demo

        System.out.println("Yard Queue:");
        yard.displayQueue();

        train.addCoach(yard.dequeue());
        train.addCoach(yard.dequeue());
        train.addCoach(yard.dequeue());
        train.addCoach(yard.dequeue());

        System.out.println("\nTrain after attaching from yard:");
        train.display();

        // ===============================
        // UC7: SORT
        // ===============================

        System.out.println("\n--- UC7: Sort Coaches ---");

        List<Coach> coachList = train.toList();

        coachList.sort(Comparator.comparingInt(Coach::getCapacity));

        for (Coach c : coachList) {
            System.out.println(c);
        }

        // ===============================
        // UC8: FILTER
        // ===============================

        System.out.println("\n--- UC8: Filter Capacity > 60 ---");

        List<Coach> filtered = coachList.stream()
                .filter(c -> c.getCapacity() > 60)
                .collect(Collectors.toList());

        for (Coach c : filtered) {
            System.out.println(c);
        }

        // ===============================
        // 🚀 UC9: GROUPING BY TYPE
        // ===============================

        System.out.println("\n--- UC9: Group Coaches by Type ---");

        Map<String, List<Coach>> grouped = coachList.stream()
                .collect(Collectors.groupingBy(Coach::getType));

        // Display grouped result
        for (Map.Entry<String, List<Coach>> entry : grouped.entrySet()) {
            System.out.println("\nType: " + entry.getKey());

            for (Coach c : entry.getValue()) {
                System.out.println(c);
            }
        }
    }
}