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
        String shape = in.nextLine();
        System.out.print("Введите длину стороны: ");
        int length = in.nextInt();

        if (length < 1) {
            System.out.println("Некорректный ввод");
            return;
        }

        System.out.println(createFigure(length, shape));
    }

    public static String createFigure(int length, String shape) {
        Main main = new Main();
        RegularFigure figure = switch (shape.toLowerCase()) {
            case "треугольник" -> main.new Triangle(length);
            case "квадрат" -> main.new Square(length);
            default -> throw new RuntimeException("Неизвестная фигура");
        };

        return figure.getFigure();
    }

    private class Square implements RegularFigure {
        private final String HORIZONTAL = "-";
        private final String VERTICAL = "|";
        private final int length;

        private Square(int length) {
            this.length = length;
        }

        @Override
        public String getFigure() {
            String square = getHorizontalSide();
            for (int i = 0; i < length - 2; i++) {
                square += getVerticalSide();
            }
            return square + getHorizontalSide();
        }

        private String getHorizontalSide() {
            return SPACE + HORIZONTAL.repeat(length - 2) + SPACE + NEXT_LINE_SYMBOL;
        }

        private String getVerticalSide() {
            return VERTICAL + SPACE.repeat(length - 2) + VERTICAL + NEXT_LINE_SYMBOL;
        }
    }

    private class Triangle implements RegularFigure {
        String RIGHT_SIDE = "\\";
        String LEFT_SIDE = "/";
        String BOTTOM_SIDE = "_";
        private final int length;

        private Triangle(int length) {
            this.length = length;
        }

        @Override
        public String getFigure() {
            return getSides() + getBottomSide();
        }

        private String getBottomSide() {
            return LEFT_SIDE + BOTTOM_SIDE.repeat(length) + RIGHT_SIDE;
        }

        private String getSides() {
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
}
