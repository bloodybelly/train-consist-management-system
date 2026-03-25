package com.train.ds;

import com.train.model.Coach;

public class CoachNode {
    Coach data;
    CoachNode next;
    CoachNode prev;

    public CoachNode(Coach data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}