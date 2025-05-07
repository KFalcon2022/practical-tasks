package com.walking.lesson14_polymorphism.task1;

import com.walking.lesson14_polymorphism.task1.model.Figure;
import com.walking.lesson14_polymorphism.task1.model.Square;
import com.walking.lesson14_polymorphism.task1.model.Triangle;

import java.util.Scanner;

/**
 * Реализуйте класс «Правильная фигура».
 * Для него создайте классы-наследники «Треугольник» и «Квадрат».
 * <p>
 * Пользователь должен иметь возможность ввести длину стороны и выбрать тип фигуры.
 * Программа должна нарисовать в консоли выбранную пользователем фигуру,
 * используя символы '-', '|', '/', '\'.
 * <p>
 * Обратите внимание, символ '\' в Java необходимо экранировать: '\\'.
 */
public class Main {
    public static void main(String[] args) {
        Figure figure = null;
        int sideLength;
        int choosedFigure;

        System.out.println("Введи длину стороны от 1 до 10:");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            sideLength = scanner.nextInt();

            if (sideLength > 0 && sideLength < 11) {
                System.out.println("Что вывести?\n1. Квадрат\n2. Треугольник");
                if (scanner.hasNextInt()) {
                    choosedFigure = scanner.nextInt();
                    if (choosedFigure == 1) {
                        figure = new Square(sideLength);
                    } else if (choosedFigure == 2) {
                        figure = new Triangle(sideLength);
                    } else {
                        System.out.println("Не правильный ввод");
                    }
                }
            } else {
                System.out.println("Не правильный ввод");
            }

        }

        scanner.close();

        System.out.println(figure.printFigure());

    }
}
