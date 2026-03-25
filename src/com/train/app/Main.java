package com.train.app;

import com.train.model.Coach;
import com.train.ds.CoachLinkedList;
import com.train.ds.CoachQueue;

public class Main {

    public static void main(String[] args) {

        CoachLinkedList train = new CoachLinkedList();
        CoachQueue yard = new CoachQueue();

        // ✅ Add coaches to waiting yard
        yard.enqueue(new Coach(201, "Sleeper", 72));
        yard.enqueue(new Coach(202, "AC", 50));
        yard.enqueue(new Coach(203, "General", 100));

        yard.displayQueue();

        // ✅ Attach coaches from yard to train
        train.addCoach(yard.dequeue());
        train.addCoach(yard.dequeue());

        System.out.println("\nTrain after attaching from yard:");
        train.display();

        // ✅ Remove and undo
        train.removeCoach(201);

        System.out.println("\nAfter removal:");
        train.display();

        train.undo();

        System.out.println("\nAfter undo:");
        train.display();

        // Remaining queue
        System.out.println("\nRemaining in Yard:");
        yard.displayQueue();
    }
}