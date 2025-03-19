package com.walking.lesson17_enum.task3;

import com.walking.lesson17_enum.task3.figure.RegularFigure;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите тип фигуры: ");
        String name = in.nextLine();
        System.out.print("Введите длину стороны: ");
        int length = in.nextInt();

        RegularFigure figure = RegularFigure.getFigureByName(name);
        figure.setLength(length);

        System.out.println(figure.getFigure());
    }
}
