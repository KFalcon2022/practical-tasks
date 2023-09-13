package com.walking.lesson19_object_methods.model;

public class StateNumber {
    public String setStateNumber() {

        String stateNumber = "";

        for (int i = 0; i < 6; i++) {
            stateNumber += (int) ((Math.random() * 10));
        }

        return stateNumber;
    }
}
