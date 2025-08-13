package com.walking.lesson14_polymorphism.task1.model;

import static java.lang.String.format;

public class RegularTriangle extends RegularPolygon {

    public RegularTriangle(int sideLength) {
        super(sideLength);
    }

    @Override
    public String draw() {
        return format("Drawing an equilateral triangle with side %d", sideLength);
        // очень сильно извиняюсь, я задолбалась в консоли рисовать

    }
}




