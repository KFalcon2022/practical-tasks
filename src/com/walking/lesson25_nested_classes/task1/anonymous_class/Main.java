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
        String figureType = in.nextLine();
        System.out.print("Введите длину стороны: ");
        int length = in.nextInt();

        if (length < 1) {
            System.out.println("Некорректный ввод");
            return;
        }

        System.out.println(getResult(length, figureType));
    }

    public static String getResult(int length, String figureType) {
        switch (figureType.toLowerCase()) {
            case "треугольник":
                RegularFigure triangle = new RegularFigure() {
                    @Override
                    public String getFigure() {
                        int k = length / 2;
                        int j = length % 2;

                        String triangle = "";
                        for (int i = 0; i < length / 2; i++) {
                            triangle += SPACE.repeat(k) + LEFT_SIDE + SPACE.repeat(j) + RIGHT_SIDE + NEXT_LINE_SYMBOL;
                            k--;
                            j += 2;
                        }
                        return triangle + LEFT_SIDE + BOTTOM_SIDE.repeat(length) + RIGHT_SIDE;
                    }
                };
                return triangle.getFigure();

            case "квадрат":
                RegularFigure square = new RegularFigure() {
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
                return square.getFigure();

            default:
                RegularFigure unknown = new RegularFigure() {
                    @Override
                    public String getFigure() {
                        return "Неизвестная фигура";
                    }
                } ;
                return unknown.getFigure();
        }
    }
}
