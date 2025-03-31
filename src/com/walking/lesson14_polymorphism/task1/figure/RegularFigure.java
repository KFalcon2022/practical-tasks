package com.walking.lesson14_polymorphism.task1.figure;

public class RegularFigure {
    private final int length;

    public RegularFigure(int length) {
        this.length = length;
    }

    public String getFigure() {
        return "Неизвестная фигура";
    }


    public int getLength() {
        return length;
    }
}
