package com.walking.lesson14_polymorphism.task1;

public class Figure {

    public final int sides;
    public final int sideSize;
    protected final String NEWLINE = "\n";

    public Figure(int sides, int sideSize) {
        this.sides = sides;
        this.sideSize = sideSize;
    }

    public void draw() {
        System.out.print("." + NEWLINE);
    }

    // Не то чтоб сильно помогало, но надо же что-то в основной класс запихать
    protected void drawLine(String start, String middle, String end) {
        System.out.print(start);
        for (int i=0; i<this.sideSize; i++){
            System.out.print(middle);
        }
        System.out.print(end + NEWLINE);
    }
}
