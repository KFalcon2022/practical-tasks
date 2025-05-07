package com.walking.lesson25_nested_classes.task1.anonymous_class;

import com.walking.lesson25_nested_classes.task1.anonymous_class.model.Figure;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
 */
public class Main {
    private static final String EMPTY_ELEMENT = " ";
    private static final String EMPTY_STRING = "";
    private static final String NEXT_LINE = "\n";
    private static final String VERTICAL_LINE = "|";
    private static final String HORISONT_LINE = "--";
    private static final String LEFT_SIDE = "/";
    private static final String RIGHT_SIDE = "\\";
    private static final String BOTTOM_LINE = "--";

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
                figure = new Figure() {

                    @Override
                    public int getLength() {
                        return sideLength;
                    }

                    @Override
                    public String printFigure() {
                        String result = EMPTY_STRING;

                        result += printHorisontLine();
                        result += printVerticalLine();
                        result += printHorisontLine();

                        return result;
                    }

                    private String printHorisontLine() {
                        String result = EMPTY_STRING;

                        for (int i = 0; i < sideLength; i++) {
                            result += HORISONT_LINE;
                        }
                        result += NEXT_LINE;

                        return result;
                    }

                    private String printVerticalLine() {
                        String result = EMPTY_STRING;

                        for (int i = 0; i < sideLength; i++) {
                            for (int j = 0; j < sideLength; j++) {
                                if (j == 0) {
                                    result += VERTICAL_LINE;
                                } else if (j == sideLength - 1) {
                                    result += VERTICAL_LINE + NEXT_LINE;
                                } else {
                                    result += EMPTY_ELEMENT;
                                }
                            }
                        }

                        return result;
                    }
                };
                break;
            case 2:
                figure = new Figure() {
                    @Override
                    public int getLength() {
                        return sideLength;
                    }

                    @Override
                    public String printFigure() {
                        String result = EMPTY_STRING;
                        result += printSideSides();
                        result += printBottomLine();
                        return result;
                    }

                    private String printSideSides() {
                        String result = EMPTY_STRING;

                        for (int i = 0; i < sideLength; i++) {
                            for (int j = 0; j < sideLength * 2; j++) {
                                if (j == sideLength - i - 1) {
                                    result += LEFT_SIDE;
                                } else if (j == sideLength + i) {
                                    result += RIGHT_SIDE;
                                } else {
                                    result += EMPTY_ELEMENT;
                                }
                            }

                            result += NEXT_LINE;

                        }

                        return result;
                    }

                    private String printBottomLine() {
                        String result = EMPTY_STRING;

                        for (int i = 0; i < sideLength; i++) {
                            result += BOTTOM_LINE;
                        }
                        result += NEXT_LINE;

                        return result;
                    }
                };
                break;
            default:
                System.out.println("Не известная фигура");
        }
        return figure;
    }
}
