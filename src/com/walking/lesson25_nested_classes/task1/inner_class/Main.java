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
        Main main = new Main();

        Scanner in = new Scanner(System.in);
        System.out.print("Введите тип фигуры: ");
        String figureType = in.nextLine();
        System.out.print("Введите длину стороны: ");
        int length = in.nextInt();

        if (length < 1) {
            System.out.println("Некорректный ввод");
            return;
        }

        switch (figureType.toLowerCase()) {
            case "треугольник":
                System.out.println(main.new Triangle(length).getFigure());
                break;
            case "квадрат":
                System.out.println(main.new Square(length).getFigure());
                break;
            default:
                System.out.println("Неизвестная фигура");
                break;
        }
    }

    class Square implements RegularFigure {
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

    class Triangle implements RegularFigure {
        private final int length;

        private Triangle(int length) {
            this.length = length;
        }

        @Override
        public String getFigure() {
            return getTriangle() + getBottomSide();
        }

        private String getBottomSide() {
            return LEFT_SIDE + BOTTOM_SIDE.repeat(length) + RIGHT_SIDE;
        }

        private String getTriangle() {
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
