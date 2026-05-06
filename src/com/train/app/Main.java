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

        train.addCoach(yard.dequeue());
        train.addCoach(yard.dequeue());
        train.addCoach(yard.dequeue());
        train.addCoach(yard.dequeue());

        List<Coach> coachList = train.toList();

        // ===============================
        // 🚀 UC13: PERFORMANCE COMPARISON
        // ===============================

        System.out.println("\n--- UC13: Loop vs Stream Performance ---");

        // Create large dataset (important for meaningful timing)
        List<Coach> bigList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bigList.add(new Coach(i, "Type" + (i % 3), (i % 100) + 1));
        }

        // -------------------------------
        // LOOP-BASED FILTERING
        // -------------------------------
        long startLoop = System.nanoTime();

        List<Coach> loopResult = new ArrayList<>();
        for (Coach c : bigList) {
            if (c.getCapacity() > 60) {
                loopResult.add(c);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // -------------------------------
        // STREAM-BASED FILTERING
        // -------------------------------
        long startStream = System.nanoTime();

        List<Coach> streamResult = bigList.stream()
                .filter(c -> c.getCapacity() > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // -------------------------------
        // RESULTS
        // -------------------------------
        System.out.println("Loop Time (nanoseconds): " + loopTime);
        System.out.println("Stream Time (nanoseconds): " + streamTime);

        // Optional comparison
        if (loopTime < streamTime) {
            System.out.println("Loop is faster in this run.");
        } else {
            System.out.println("Stream is faster in this run.");
        }
    }
}