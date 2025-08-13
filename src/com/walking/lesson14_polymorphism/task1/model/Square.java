package com.walking.lesson14_polymorphism.task1.model;

import static java.lang.String.format;

public class Square extends RegularPolygon {

    public Square(int sideLength) {
        super(sideLength);
    }

    @Override
    public String draw() {
        return format("Drawing a %d * %d square", sideLength, sideLength);
        // рисование в консоли

    }
}
