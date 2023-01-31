package com.walking.lesson20_exceptions.task2.model;

public abstract class Shape {
    protected static final String EMPTY_ELEMENT = " ";
    protected static final String EMPTY_STRING = "";
    protected static final char NEW_LINE_SYMBOL = '\n';

    protected final int length;

    protected Shape(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    abstract public String render();
}
