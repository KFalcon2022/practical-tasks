package com.walking.lesson25_nested_classes.task1.anonymous_class;

import com.walking.lesson25_nested_classes.task1.anonymous_class.figure.RegularFigure;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите тип фигуры: ");
        String shape = in.nextLine();
        System.out.print("Введите длину стороны: ");
        int length = in.nextInt();

        if (length < 1) {
            System.out.println("Некорректный ввод");
            return;
        }

        System.out.println(getResult(length, shape));
    }

    public static String getResult(int length, String shape) {
        RegularFigure figure;

        switch (shape.toLowerCase()) {
            case "треугольник":
                figure = getTriangle(length);
                break;
            case "квадрат":
                figure = getSquare(length);
                break;
            default:
                throw new RuntimeException("Unknown shape");
        }
        return figure.getFigure();
    }

    public static RegularFigure getTriangle(int length) {
        return new RegularFigure() {
            @Override
            public String getFigure() {
                int k = length / 2;
                int j = length % 2;

                String triangle1 = "";
                for (int i = 0; i < length / 2; i++) {
                    triangle1 += SPACE.repeat(k) + LEFT_SIDE + SPACE.repeat(j) + RIGHT_SIDE + NEXT_LINE_SYMBOL;
                    k--;
                    j += 2;
                }
                return triangle1 + LEFT_SIDE + BOTTOM_SIDE.repeat(length) + RIGHT_SIDE;
            }
        };
    }

    public static RegularFigure getSquare(int length) {
        return new RegularFigure() {
            @Override
            public String getFigure() {
                String horizontal = SPACE + HORIZONTAL.repeat(length - 2) + SPACE + NEXT_LINE_SYMBOL;
                String square = horizontal;
                for (int i = 0; i < length - 2; i++) {
                    square += VERTICAL + SPACE.repeat(length - 2) + VERTICAL + NEXT_LINE_SYMBOL;
                }
                return square + horizontal;
            }
        };
    }
}
