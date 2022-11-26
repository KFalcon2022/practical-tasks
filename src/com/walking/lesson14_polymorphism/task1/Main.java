package com.walking.lesson14_polymorphism.task1;

public class Main {
    public static void main(String[] args) {
        RegularTriangle triangle = new RegularTriangle();
        RegularRectangle rectangle = new RegularRectangle();

        RegularFigure figure = triangle;
        figure.draw(7);

        System.out.println();

        figure = rectangle;
        figure.draw(6);
    }
}
