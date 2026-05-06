package com.train.app;

import com.train.model.GoodsBogie;

import java.util.Arrays;
import java.util.List;

public class Main {

        public static void main(String[] args) {

                // =========================
                // GOODS BOGIES
                // =========================
                List<GoodsBogie> bogies = Arrays.asList(
                        new GoodsBogie(1, "CYLINDRICAL", "PETROLEUM"),
                        new GoodsBogie(2, "RECTANGULAR", "COAL"),
                        new GoodsBogie(3, "CYLINDRICAL", "PETROLEUM")
                );

                // =========================
                // SAFETY CHECK (UC12)
                // =========================
                boolean isSafe = bogies.stream()
                        .allMatch(b -> {

                                if (b.getShape().equalsIgnoreCase("CYLINDRICAL")) {
                                        return b.getCargo().equalsIgnoreCase("PETROLEUM");
                                }

                                // other shapes allowed any cargo
                                return true;
                        });

                // =========================
                // RESULT
                // =========================
                System.out.println("Train Safety Status: " + (isSafe ? "SAFE" : "UNSAFE"));
        }
}