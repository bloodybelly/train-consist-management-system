package com.train.app;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;

public class TrainApp {

    public static void main(String[] args) {

        // ================= UC1 =================
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully.");
        System.out.println("Initial number of coaches: " + trainConsist.size());

        // ================= UC2 =================

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("\nAfter Adding Bogies:");
        System.out.println(trainConsist);

        trainConsist.remove("AC Chair");

        System.out.println("\nAfter Removing AC Chair:");
        System.out.println(trainConsist);

        if (trainConsist.contains("Sleeper")) {
            System.out.println("\nSleeper coach exists in the train.");
        }

        System.out.println("\nFinal Train Consist:");
        System.out.println(trainConsist);

        // ================= UC3 =================

        Set<Integer> bogieIds = new HashSet<>();

        bogieIds.add(101);
        bogieIds.add(102);
        bogieIds.add(103);
        bogieIds.add(101);
        bogieIds.add(102);

        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogieIds);

        // ================= UC4 =================

        LinkedList<String> linkedTrain = new LinkedList<>();

        // Add bogies
        linkedTrain.add("Engine");
        linkedTrain.add("Sleeper");
        linkedTrain.add("AC");
        linkedTrain.add("Cargo");
        linkedTrain.add("Guard");

        System.out.println("\nInitial LinkedList Train:");
        System.out.println(linkedTrain);

        // Insert Pantry Car at position 2
        linkedTrain.add(2, "Pantry Car");

        System.out.println("\nAfter Inserting Pantry Car at position 2:");
        System.out.println(linkedTrain);

        // Remove first and last
        linkedTrain.removeFirst();
        linkedTrain.removeLast();

        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(linkedTrain);

        System.out.println("\nSystem ready for further operations.");
    }
}