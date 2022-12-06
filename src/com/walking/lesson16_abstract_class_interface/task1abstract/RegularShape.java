package com.walking.lesson16_abstract_class_interface.task1abstract;

public abstract class RegularShape {
    int shapeLength;

    protected RegularShape(int shapeLength) {
        this.shapeLength = shapeLength;
    }

    protected abstract void draw();
}