package com.train.app;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashSet;

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

        linkedTrain.add("Engine");
        linkedTrain.add("Sleeper");
        linkedTrain.add("AC");
        linkedTrain.add("Cargo");
        linkedTrain.add("Guard");

        System.out.println("\nInitial LinkedList Train:");
        System.out.println(linkedTrain);

        linkedTrain.add(2, "Pantry Car");

        System.out.println("\nAfter Inserting Pantry Car at position 2:");
        System.out.println(linkedTrain);

        linkedTrain.removeFirst();
        linkedTrain.removeLast();

        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(linkedTrain);

        // ================= UC5 =================

        LinkedHashSet<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // duplicate attempt
        formation.add("Sleeper");

        System.out.println("\nTrain Formation (LinkedHashSet):");
        System.out.println(formation);

        System.out.println("\nSystem ready for further operations.");
    }
}