package com.train.app;

import com.train.model.Coach;
import com.train.ds.CoachLinkedList;
import com.train.ds.CoachQueue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

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
        yard.enqueue(new Coach(204, "AC", 60));

        System.out.println("Yard Queue:");
        yard.displayQueue();

        train.addCoach(yard.dequeue());
        train.addCoach(yard.dequeue());
        train.addCoach(yard.dequeue());
        train.addCoach(yard.dequeue());

        System.out.println("\nTrain after attaching from yard:");
        train.display();

        // Convert LinkedList → List
        List<Coach> coachList = train.toList();

        // ===============================
        // UC7: SORT
        // ===============================
        coachList.sort(Comparator.comparingInt(Coach::getCapacity));

        // ===============================
        // UC8: FILTER
        // ===============================
        List<Coach> filtered = coachList.stream()
                .filter(c -> c.getCapacity() > 60)
                .collect(Collectors.toList());

        // ===============================
        // UC9: GROUPING
        // ===============================
        Map<String, List<Coach>> grouped = coachList.stream()
                .collect(Collectors.groupingBy(Coach::getType));

        // ===============================
        // UC10: REDUCE
        // ===============================
        int totalCapacity = coachList.stream()
                .map(Coach::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Capacity: " + totalCapacity);

        // ===============================
        // 🚀 UC11: REGEX VALIDATION
        // ===============================

        Scanner sc = new Scanner(System.in);

        // Patterns
        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        // Input
        System.out.println("\n--- UC11: Regex Validation ---");

        System.out.print("Enter Train ID (format TRN-1234): ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code (format PET-AB): ");
        String cargoCode = sc.nextLine();

        // Matching
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        // Validation
        if (trainMatcher.matches()) {
            System.out.println("Valid Train ID ✅");
        } else {
            System.out.println("Invalid Train ID ❌");
        }

        if (cargoMatcher.matches()) {
            System.out.println("Valid Cargo Code ✅");
        } else {
            System.out.println("Invalid Cargo Code ❌");
        }

        sc.close();
    }
}