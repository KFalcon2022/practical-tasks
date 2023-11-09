package com.walking.lesson20_exceptions.task2.model;

public abstract class EquilateralShape {

    final int length;

    protected EquilateralShape(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public abstract String getStringShape();
}
