package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task1_interface.model.Painting;
import com.walking.lesson16_abstract_class_interface.task2.model.CorrectShape;
import com.walking.lesson16_abstract_class_interface.task2.model.Square;
import com.walking.lesson16_abstract_class_interface.task2.model.Triangle;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * с использованием интерфейсов. Каждая реализация должна возвращать свое сообщение.
 */
public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int sideLength = inputSideLength(SCANNER);
        int typeFigure = inputFigureType(SCANNER);

        SCANNER.close();

        CorrectShape figure = null;
        switch (typeFigure) {
            case 1 -> figure = new Square();
            case 2 -> figure = new Triangle();
            default -> System.out.println("incorrect input");
        }

        if (figure != null) {
            figure.draw(sideLength);
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
