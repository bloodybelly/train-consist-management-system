package com.train.app;

import com.train.model.Coach;
import com.train.ds.CoachLinkedList;
import com.train.ds.CoachQueue;
import com.train.exception.InvalidCapacityException;
import com.train.exception.CargoSafetyException;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Main {

        public static void main(String[] args) {

                CoachLinkedList train = new CoachLinkedList();
                CoachQueue yard = new CoachQueue();

                // ===============================
                // INITIAL SETUP (UC14 handled)
                // ===============================
                try {
                        yard.enqueue(new Coach(201, "Sleeper", 72, "Rectangular"));
                        yard.enqueue(new Coach(202, "AC", 50, "Rectangular"));
                        yard.enqueue(new Coach(203, "General", 100, "Rectangular"));
                        yard.enqueue(new Coach(204, "AC", 60, "Cylindrical"));
                } catch (InvalidCapacityException e) {
                        System.out.println("Capacity Error: " + e.getMessage());
                }

                System.out.println("Yard Queue:");
                yard.displayQueue();

                train.addCoach(yard.dequeue());
                train.addCoach(yard.dequeue());
                train.addCoach(yard.dequeue());
                train.addCoach(yard.dequeue());

                System.out.println("\nTrain:");
                train.display();

                List<Coach> coachList = train.toList();

                // ===============================
                // UC7: SORT
                // ===============================
                System.out.println("\n--- UC7: Sorting ---");
                coachList.sort(Comparator.comparingInt(Coach::getCapacity));
                coachList.forEach(System.out::println);

                // ===============================
                // UC8: FILTER
                // ===============================
                System.out.println("\n--- UC8: Filter Capacity > 60 ---");
                List<Coach> filtered = coachList.stream()
                        .filter(c -> c.getCapacity() > 60)
                        .collect(Collectors.toList());
                filtered.forEach(System.out::println);

                // ===============================
                // UC9: GROUPING
                // ===============================
                System.out.println("\n--- UC9: Group by Type ---");
                Map<String, List<Coach>> grouped =
                        coachList.stream().collect(Collectors.groupingBy(Coach::getType));

                grouped.forEach((type, list) -> {
                        System.out.println("\nType: " + type);
                        list.forEach(System.out::println);
                });

                // ===============================
                // UC10: REDUCE
                // ===============================
                System.out.println("\n--- UC10: Total Capacity ---");
                int total = coachList.stream()
                        .map(Coach::getCapacity)
                        .reduce(0, Integer::sum);
                System.out.println("Total Capacity: " + total);

                // ===============================
                // UC11: REGEX
                // ===============================
                System.out.println("\n--- UC11: Regex Validation ---");

                Scanner sc = new Scanner(System.in);

                Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
                Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

                System.out.print("Enter Train ID: ");
                String trainId = sc.nextLine();

                System.out.print("Enter Cargo Code: ");
                String cargoCode = sc.nextLine();

                System.out.println(trainPattern.matcher(trainId).matches()
                        ? "Valid Train ID"
                        : "Invalid Train ID");

                System.out.println(cargoPattern.matcher(cargoCode).matches()
                        ? "Valid Cargo Code"
                        : "Invalid Cargo Code");

                // ===============================
                // UC13: PERFORMANCE
                // ===============================
                System.out.println("\n--- UC13: Performance ---");

                List<Coach> bigList = new ArrayList<>();
                for (int i = 0; i < 100000; i++) {
                        try {
                                bigList.add(new Coach(i, "Type" + (i % 3), (i % 100) + 1, "Rectangular"));
                        } catch (InvalidCapacityException ignored) {}
                }

                long startLoop = System.nanoTime();
                List<Coach> loopResult = new ArrayList<>();
                for (Coach c : bigList) {
                        if (c.getCapacity() > 60) loopResult.add(c);
                }
                long loopTime = System.nanoTime() - startLoop;

                long startStream = System.nanoTime();
                List<Coach> streamResult = bigList.stream()
                        .filter(c -> c.getCapacity() > 60)
                        .collect(Collectors.toList());
                long streamTime = System.nanoTime() - startStream;

                System.out.println("Loop Time: " + loopTime);
                System.out.println("Stream Time: " + streamTime);

                // ===============================
                // UC15: RUNTIME EXCEPTION
                // ===============================
                System.out.println("\n--- UC15: Cargo Safety ---");

                try {
                        Coach c1 = new Coach(301, "Goods", 80, "Rectangular");
                        Coach c2 = new Coach(302, "Goods", 90, "Cylindrical");

                        c2.assignCargo("Petroleum"); // safe
                        c1.assignCargo("Petroleum"); // unsafe

                } catch (InvalidCapacityException e) {
                        System.out.println(e.getMessage());
                } catch (CargoSafetyException e) {
                        System.out.println("Error: " + e.getMessage());
                } finally {
                        System.out.println("Operation completed safely.");
                }

                // ===============================
                // UC16: BUBBLE SORT
                // ===============================
                System.out.println("\n--- UC16: Bubble Sort ---");

                int[] arr = {72, 50, 100, 60, 40};

                System.out.print("Before: ");
                for (int x : arr) System.out.print(x + " ");

                for (int i = 0; i < arr.length - 1; i++) {
                        for (int j = 0; j < arr.length - i - 1; j++) {
                                if (arr[j] > arr[j + 1]) {
                                        int temp = arr[j];
                                        arr[j] = arr[j + 1];
                                        arr[j + 1] = temp;
                                }
                        }
                }

                System.out.print("\nAfter: ");
                for (int x : arr) System.out.print(x + " ");

                // ===============================
                // 🚀 UC17: ARRAYS.SORT
                // ===============================
                System.out.println("\n\n--- UC17: Arrays.sort() ---");

                String[] bogieTypes = {"Sleeper", "AC", "General", "FirstClass", "ChairCar"};

                System.out.println("Before Sorting:");
                System.out.println(Arrays.toString(bogieTypes));

                Arrays.sort(bogieTypes);  // Built-in sorting

                System.out.println("After Sorting (Alphabetical):");
                System.out.println(Arrays.toString(bogieTypes));

                System.out.println("\nProgram completed successfully.");
        }
}