package com.walking.lesson25_nested_classes.task1.static_class;

import com.walking.lesson25_nested_classes.task1.static_class.figure.RegularFigure;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя статические вложенные классы.
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

        System.out.println(getFigure(figureType).getFigure(length));
    }

    public static RegularFigure getFigure(String figureType) {
        return switch (figureType.toLowerCase()) {
            case "треугольник" -> new Triangle();
            case "квадрат" -> new Square();
            default -> new Unknown();
        };
    }


    static class Square implements RegularFigure {
        public String getFigure(int length) {
            String square = getHorizontalSide(length);
            for (int i = 0; i < length - 2; i++) {
                square += getVerticalSide(length);
            }
            return square + getHorizontalSide(length);
        }

        private String getHorizontalSide(int length) {
            return SPACE + HORIZONTAL.repeat(length - 2) + SPACE + NEXT_LINE_SYMBOL;
        }

        private String getVerticalSide(int length) {
            return VERTICAL + SPACE.repeat(length - 2) + VERTICAL + NEXT_LINE_SYMBOL;
        }
    }

    static class Triangle implements RegularFigure {
        public String getFigure(int length) {
            return getTriangle(length) + getBottomSide(length);
        }

        private String getBottomSide(int length) {
            return LEFT_SIDE + BOTTOM_SIDE.repeat(length) + RIGHT_SIDE;
        }

        private String getTriangle(int length) {
            int k = length / 2;
            int j = length % 2;

            String triangle = "";
            for (int i = 0; i < length / 2; i++) {
                triangle += SPACE.repeat(k) + LEFT_SIDE + SPACE.repeat(j) + RIGHT_SIDE + NEXT_LINE_SYMBOL;
                k--;
                j += 2;
            }

            return triangle;
        }
    }

    static class Unknown implements RegularFigure {
        public String getFigure(int length) {
            return "Неизвестная фигура";
        }
    }
}
