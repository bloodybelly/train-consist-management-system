package com.train.app;

import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    public static void main(String[] args) {

        // UC1: Initialization
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully.");
        System.out.println("Initial number of coaches: " + trainConsist.size());

        // UC2: Add bogies
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("\nAfter Adding Bogies:");
        System.out.println(trainConsist);

        // UC2: Remove a bogie
        trainConsist.remove("AC Chair");

        System.out.println("\nAfter Removing AC Chair:");
        System.out.println(trainConsist);

        // UC2: Check existence
        if (trainConsist.contains("Sleeper")) {
            System.out.println("\nSleeper coach exists in the train.");
        } else {
            System.out.println("\nSleeper coach not found.");
        }

        // Final state
        System.out.println("\nFinal Train Consist:");
        System.out.println(trainConsist);

        System.out.println("\nSystem ready for further operations.");
    }
}