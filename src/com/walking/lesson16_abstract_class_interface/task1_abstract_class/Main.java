package com.walking.lesson16_abstract_class_interface.task1_abstract_class;

import com.walking.lesson14_polymorphism.task1.model.Figure;
import com.walking.lesson14_polymorphism.task1.model.Square;
import com.walking.lesson14_polymorphism.task1.model.Triangle;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя абстрактный класс.
 */
public class Main {
    public static void main(String[] args) {

        int sideLength;
        int choosedFigure;

        System.out.println("Введи длину стороны:");

        Scanner scanner = new Scanner(System.in);

        sideLength = scanner.nextInt();

        System.out.println("Что вывести?\n1. Квадрат\n2. Треугольник");

        choosedFigure = scanner.nextInt();

        Figure figure = null;

        if (choosedFigure == 1) {
            figure = new Square(sideLength);
        } else if (choosedFigure == 2) {
            figure = new Triangle(sideLength);
        } else {
            System.out.println("Не правильный ввод");
        }

        scanner.close();

        System.out.println(figure.printFigure());
    }
}
