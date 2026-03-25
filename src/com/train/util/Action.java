package com.train.util;

import com.train.model.Coach;

public class Action {

    public String type;   // "ADD" or "REMOVE"
    public Coach coach;   // coach involved in the action

    public Action(String type, Coach coach) {
        this.type = type;
        this.coach = coach;
    }
}