package com.walking.lesson16_abstract_class_interface.task1_abstract_class.model;

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
