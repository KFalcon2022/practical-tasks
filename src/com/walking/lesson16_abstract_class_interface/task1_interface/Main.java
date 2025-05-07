package com.walking.lesson16_abstract_class_interface.task1_interface;

import com.walking.lesson16_abstract_class_interface.task1_interface.model.Figure;
import com.walking.lesson16_abstract_class_interface.task1_interface.model.Square;
import com.walking.lesson16_abstract_class_interface.task1_interface.model.Triangle;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя интерфейс.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Введи длину стороны от 1 до 10:");
        Scanner scanner = new Scanner(System.in);

        int sideLength;
        sideLength = scanner.nextInt();

        System.out.println("Что вывести?\n1. Квадрат\n2. Треугольник");
        int choosedFigure;
        choosedFigure = scanner.nextInt();

        scanner.close();

        if ((sideLength < 1 || sideLength > 11) || (choosedFigure != 1 && choosedFigure != 2)) {
            System.out.println("Не правильный ввод");
            return;
        }

        Figure figure = figured(sideLength, choosedFigure);
        System.out.println(figure.printFigure());
    }

    private static Figure figured(int sideLength, int choosedFigure) {
        Figure figure = null;

        switch (choosedFigure) {
            case 1:
                figure = new Square(sideLength);
                break;
            case 2:
                figure = new Triangle(sideLength);
                break;
            default:
                System.out.println("Не известная фигура");
        }
        return figure;
    }
}
