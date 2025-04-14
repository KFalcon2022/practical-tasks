package com.walking.lesson25_nested_classes.task1.inner_class;

import com.walking.lesson25_nested_classes.task1.inner_class.figure.RegularFigure;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя внутренние классы.
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

        System.out.println(getResult(figureType).getFigure(length));
    }

    public static RegularFigure getResult(String figureType) {
        return switch(figureType.toLowerCase()) {
            case "треугольник" -> new RegularFigure.Triangle();
            case "квадрат" -> new RegularFigure.Square();
            default -> new RegularFigure.Unknown();
        };
    }
}
