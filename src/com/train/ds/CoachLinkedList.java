package com.train.ds;

import com.train.model.Coach;
import com.train.util.Action;
import java.util.Stack;

public class CoachLinkedList {

    private CoachNode head;
    private CoachNode tail;

    private Stack<Action> history = new Stack<>();

    // ✅ Check if coach already exists
    public boolean containsCoach(int coachId) {
        CoachNode temp = head;

        while (temp != null) {
            if (temp.data.getCoachId() == coachId) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // ✅ Add coach (with validation + history)
    public void addCoach(Coach coach) {

        if (containsCoach(coach.getCoachId())) {
            System.out.println("Duplicate coach not allowed: " + coach.getCoachId());
            return;
        }

        addCoachInternal(coach);
        history.push(new Action("ADD", coach));

        System.out.println("Coach added: " + coach.getCoachId());
    }

    // ✅ Internal add (no history)
    private void addCoachInternal(Coach coach) {
        CoachNode newNode = new CoachNode(coach);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // ✅ Display train
    public void display() {
        if (head == null) {
            System.out.println("Train is empty!");
            return;
        }

        CoachNode temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // ✅ Remove coach (with history)
    public void removeCoach(int coachId) {
        CoachNode temp = head;

        while (temp != null) {

            if (temp.data.getCoachId() == coachId) {

                history.push(new Action("REMOVE", temp.data));
                removeCoachInternal(coachId);

                System.out.println("Coach removed: " + coachId);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Coach not found!");
    }

    // ✅ Internal remove (no history)
    private void removeCoachInternal(int coachId) {
        CoachNode temp = head;

        while (temp != null) {

            if (temp.data.getCoachId() == coachId) {

                // Only one node
                if (head == tail) {
                    head = tail = null;
                }
                // Remove head
                else if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                }
                // Remove tail
                else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                }
                // Remove middle
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }

            temp = temp.next;
        }
    }

    // ✅ Undo last operation
    public void undo() {

        if (history.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }

        Action lastAction = history.pop();

        if (lastAction.type.equals("ADD")) {
            removeCoachInternal(lastAction.coach.getCoachId());
            System.out.println("Undo: Add reversed");
        }

        else if (lastAction.type.equals("REMOVE")) {
            addCoachInternal(lastAction.coach);
            System.out.println("Undo: Remove reversed");
        }
    }
}