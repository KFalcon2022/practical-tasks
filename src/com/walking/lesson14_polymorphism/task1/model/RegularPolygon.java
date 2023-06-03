package com.walking.lesson14_polymorphism.task1.model;

public class RegularPolygon {
    protected int sideLength;

    public RegularPolygon(int sideLength) {
        this.sideLength = sideLength;
    }

    public String draw() {
        return "Drawing the figure";
    }
}
