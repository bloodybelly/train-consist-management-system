package com.train.app;

import com.train.model.Coach;
import com.train.exception.InvalidCapacityException;
import com.train.exception.CargoSafetyException;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n--- UC15: Cargo Safety Handling ---");

        try {
            // Create coaches
            Coach c1 = new Coach(301, "Goods", 80, "Rectangular");
            Coach c2 = new Coach(302, "Goods", 90, "Cylindrical");

            // Safe assignment
            c2.assignCargo("Petroleum");

            // ❌ Unsafe assignment (will throw exception)
            c1.assignCargo("Petroleum");

        } catch (CargoSafetyException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (InvalidCapacityException e) {

            System.out.println("Capacity Error: " + e.getMessage());

        } finally {

            System.out.println("Operation completed (logged safely).");
        }

        // Program continues
        System.out.println("\nApplication still running...");
    }
}