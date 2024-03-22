package com.walking.lesson17_enum.task3;


import com.walking.lesson17_enum.task3.model.SHAPES;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */
public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int sideLength = inputSideLength(SCANNER);
        int typeFigure = inputFigureType(SCANNER);
        SHAPES shape = null;
        SCANNER.close();

        switch (typeFigure) {
            case 1 -> shape = SHAPES.SQUARE;
            case 2 -> shape = SHAPES.TRIANGLE;
            default -> System.out.println("incorrect input");
        }
        if (shape != null) {
            shape.draw(sideLength);
        }
    }

    private static int inputSideLength(Scanner scanner) {
        System.out.println("Введите длину стороны:");
        return scanner.nextInt();
    }

    private static int inputFigureType(Scanner scanner) {
        System.out.println("Введите тип фигуры (1 - квадрат, 2 - треугольник)");
        return scanner.nextInt();
    }
}
