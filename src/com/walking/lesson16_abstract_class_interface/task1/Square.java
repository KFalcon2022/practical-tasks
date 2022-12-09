package com.walking.lesson16_abstract_class_interface.task1;

public class Square extends Figure {

    private final String SPACE = " ";
    private final String LR = "│";
    private final String TB = "─";
    private final String LB = "└";
    private final String RT = "┐";
    private final String RB = "┘";
    private final String LT = "┌";

    public Square(int sideSize) {
        super(4, sideSize);
    }

    // Рисуется размером size+2 ради углов.
    // Можно сделать и ровно, но тогда надо реализовывать
    // обработку маленьких размеров
    public void draw() {
        this.print(LT, TB, RT);
        for (int i = 0; i < this.sideSize; i++){
            this.print(LR, SPACE, LR);
        }
        this.print(LB, TB, RB);
    }
}