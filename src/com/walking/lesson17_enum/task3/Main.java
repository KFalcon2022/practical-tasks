package com.walking.lesson17_enum.task3;

import com.walking.lesson17_enum.task3.model.EquilateralShape;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Что вывести?\n1. Квадрат\n2. Треугольник");

        Scanner scanner = new Scanner(System.in);

        int choosedFigure = scanner.nextInt();

        EquilateralShape figure = null;

        if (choosedFigure == 1) {
            figure = EquilateralShape.SQUARE;
        }
        if (choosedFigure == 2) {
            figure = EquilateralShape.EQUILATERAL_TRIANGLE;
        }

        scanner.close();

        System.out.println(figure.printFigure());
    }
}
