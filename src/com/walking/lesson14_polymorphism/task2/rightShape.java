package com.walking.lesson14_polymorphism.task2;

public class rightShape {
    protected final int length;
    protected static final String HORIZONTAL_LINE = "-";
    protected static final String VERTICAL_LINE = "|";
    protected static final String EMPTY_ELEMENT = " ";
    protected static final String ENTER_NEW_LINE = "\n";

    protected rightShape(int length) {
        if (length > 0 && length < Integer.MAX_VALUE) {
            this.length = length;
        } else {
            this.length = 1;
            System.out.println("Wrong length");
        }

    }

    protected void draw() {
    }
}