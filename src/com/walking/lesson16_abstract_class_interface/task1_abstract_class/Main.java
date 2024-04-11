package com.walking.lesson16_abstract_class_interface.task1_abstract_class;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя абстрактный класс.
 */

import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.CorrectFigure;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.Square;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.model.Triangle;

import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int sideLength = inputSideLength(SCANNER);
        int typeFigure = inputFigureType(SCANNER);
        ;
        SCANNER.close();

        CorrectFigure figure = null;
        switch (typeFigure) {
            case 1 -> figure = new Square(sideLength);
            case 2 -> figure = new Triangle(sideLength);
            default -> System.out.println("incorrect input");
        }

        if (figure != null) {
            figure.drawFigure(sideLength);
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


