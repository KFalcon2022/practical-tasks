package com.walking.lesson16_abstract_class_interface.task1_abstract_class;


import com.walking.lesson16_abstract_class_interface.task1_abstract_class.figures.RegularFigure;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.figures.Square;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.figures.Triangle;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.figures.Unknown;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя абстрактный класс.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите тип фигуры: ");
        String figureType = in.nextLine();
        System.out.print("Введите длину стороны: ");
        int length = in.nextInt();

        if (length < 1) {
            System.out.println("Некорректный ввод");
            return;
        }

        RegularFigure figure;

        switch (figureType.toLowerCase()) {
            case Triangle.NAME:
                figure = new Triangle(length);
                break;
            case Square.NAME:
                figure = new Square(length);
                break;
            default:
                figure = new Unknown(length);
        }

        System.out.println(figure.getFigure());
    }
}
