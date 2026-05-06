package com.train.ds;

import com.train.model.Coach;
import java.util.*;

public class CoachLinkedList {

    private Coach head;

    // Stack for undo (stores removed coaches)
    private Stack<Coach> undoStack = new Stack<>();

    // ===============================
    // ADD COACH
    // ===============================
    public void addCoach(Coach coach) {
        if (head == null) {
            head = coach;
        } else {
            Coach temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = coach;
        }
    }

    // ===============================
    // REMOVE COACH
    // ===============================
    public void removeCoach(int coachId) {
        if (head == null) {
            System.out.println("Train is empty!");
            return;
        }

        // If head is to be removed
        if (head.getId() == coachId) {
            undoStack.push(head);
            head = head.next;
            System.out.println("Coach removed!");
            return;
        }

        Coach current = head;
        Coach prev = null;

        while (current != null && current.getId() != coachId) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Coach not found!");
            return;
        }

        undoStack.push(current);
        prev.next = current.next;

        System.out.println("Coach removed!");
    }

    // ===============================
    // UNDO REMOVE
    // ===============================
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }

        Coach coach = undoStack.pop();
        addCoach(coach);

        System.out.println("Undo successful! Coach restored.");
    }

    // ===============================
    // DISPLAY TRAIN
    // ===============================
    public void display() {
        if (head == null) {
            System.out.println("Train is empty!");
            return;
        }

        Coach temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // ===============================
    // CONVERT TO LIST (UC7 SUPPORT)
    // ===============================
    public List<Coach> toList() {
        List<Coach> list = new ArrayList<>();
        Coach current = head;

        while (current != null) {
            list.add(current);
            current = current.next;
        }

        return list;
    }

    // ===============================
    // GET HEAD (for advanced features)
    // ===============================
    public Coach getHead() {
        return head;
    }
}