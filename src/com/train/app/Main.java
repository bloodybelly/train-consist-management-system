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
                // INITIAL SETUP
                // ===============================
                try {
                        yard.enqueue(new Coach(201, "Sleeper", 72, "Rectangular"));
                        yard.enqueue(new Coach(202, "AC", 50, "Rectangular"));
                        yard.enqueue(new Coach(203, "General", 100, "Rectangular"));
                        yard.enqueue(new Coach(204, "AC", 60, "Cylindrical"));
                } catch (InvalidCapacityException e) {
                        System.out.println("Capacity Error: " + e.getMessage());
                }

                train.addCoach(yard.dequeue());
                train.addCoach(yard.dequeue());
                train.addCoach(yard.dequeue());
                train.addCoach(yard.dequeue());

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
                Map<String, List<Coach>> grouped =
                        coachList.stream().collect(Collectors.groupingBy(Coach::getType));

                // ===============================
                // UC10: REDUCE
                // ===============================
                int total = coachList.stream()
                        .map(Coach::getCapacity)
                        .reduce(0, Integer::sum);

                System.out.println("Total Capacity: " + total);

                // ===============================
                // UC11: REGEX
                // ===============================
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
                List<Coach> bigList = new ArrayList<>();
                for (int i = 0; i < 100000; i++) {
                        try {
                                bigList.add(new Coach(i, "Type" + (i % 3), (i % 100) + 1, "Rectangular"));
                        } catch (InvalidCapacityException ignored) {}
                }

                long startLoop = System.nanoTime();
                for (Coach c : bigList) {
                        if (c.getCapacity() > 60) {}
                }
                long loopTime = System.nanoTime() - startLoop;

                long startStream = System.nanoTime();
                bigList.stream().filter(c -> c.getCapacity() > 60).collect(Collectors.toList());
                long streamTime = System.nanoTime() - startStream;

                System.out.println("Loop Time: " + loopTime);
                System.out.println("Stream Time: " + streamTime);

                // ===============================
                // UC15: RUNTIME EXCEPTION
                // ===============================
                try {
                        Coach c1 = new Coach(301, "Goods", 80, "Rectangular");
                        Coach c2 = new Coach(302, "Goods", 90, "Cylindrical");

                        c2.assignCargo("Petroleum");
                        c1.assignCargo("Petroleum");

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
                int[] arr = {72, 50, 100, 60, 40};

                for (int i = 0; i < arr.length - 1; i++) {
                        for (int j = 0; j < arr.length - i - 1; j++) {
                                if (arr[j] > arr[j + 1]) {
                                        int temp = arr[j];
                                        arr[j] = arr[j + 1];
                                        arr[j + 1] = temp;
                                }
                        }
                }

                // ===============================
                // UC17: ARRAYS.SORT
                // ===============================
                String[] bogieTypes = {"Sleeper", "AC", "General", "FirstClass", "ChairCar"};
                Arrays.sort(bogieTypes);

                // ===============================
                // UC18: LINEAR SEARCH
                // ===============================
                System.out.println("\n--- UC18: Linear Search ---");

                String[] bogieIDs = {"BG101", "BG202", "BG303", "BG404", "BG505"};

                System.out.print("Enter Bogie ID to search: ");
                String key = sc.nextLine();

                boolean found = false;

                for (String id : bogieIDs) {
                        if (id.equals(key)) {
                                found = true;
                                break;
                        }
                }

                System.out.println(found ? "Bogie ID found ✅" : "Bogie ID not found ❌");

                // ===============================
                // 🚀 UC19: BINARY SEARCH
                // ===============================
                System.out.println("\n--- UC19: Binary Search ---");

                // Sorted array (IMPORTANT)
                String[] sortedIDs = {"BG101", "BG202", "BG303", "BG404", "BG505"};

                System.out.print("Enter Bogie ID to search (Binary): ");
                String searchKey = sc.nextLine();

                int low = 0;
                int high = sortedIDs.length - 1;
                boolean foundBinary = false;

                while (low <= high) {

                        int mid = (low + high) / 2;

                        int cmp = sortedIDs[mid].compareTo(searchKey);

                        if (cmp == 0) {
                                foundBinary = true;
                                break;
                        } else if (cmp < 0) {
                                low = mid + 1;
                        } else {
                                high = mid - 1;
                        }
                }

                if (foundBinary) {
                        System.out.println("Bogie ID found using Binary Search ✅");
                } else {
                        System.out.println("Bogie ID not found ❌");
                }

                System.out.println("\nProgram completed successfully.");
                sc.close();
        }
}