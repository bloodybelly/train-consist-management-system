package com.train.ds;

import com.train.model.Coach;
import java.util.LinkedList;
import java.util.Queue;

public class CoachQueue {

    private Queue<Coach> queue = new LinkedList<>();

    // ✅ Add coach to waiting queue
    public void enqueue(Coach coach) {
        queue.add(coach);
        System.out.println("Coach added to waiting queue: " + coach.getCoachId());
    }

    // ✅ Remove coach from queue
    public Coach dequeue() {
        if (queue.isEmpty()) {
            System.out.println("No coaches in waiting queue!");
            return null;
        }

        Coach coach = queue.poll();
        System.out.println("Coach removed from queue: " + coach.getCoachId());
        return coach;
    }

    // ✅ Display queue
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Waiting queue is empty!");
            return;
        }

        System.out.println("Waiting Coaches:");
        for (Coach c : queue) {
            System.out.println(c);
        }
    }
}