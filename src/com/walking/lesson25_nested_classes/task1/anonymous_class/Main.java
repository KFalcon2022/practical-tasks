package com.walking.lesson25_nested_classes.task1.anonymous_class;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sideLength = inputSideLength(scanner);
        int typeFigure = inputTypeFigure(scanner);
        scanner.close();

        drawFigure(sideLength, typeFigure);
    }

    private static int inputSideLength(Scanner scanner) {
        System.out.println("Введите длину стороны");
        return scanner.nextInt();
    }

    private static int inputTypeFigure(Scanner scanner) {
        System.out.println("Введите тип фигуры, где 1 - треугольник, 2 - квадрат");
        return scanner.nextInt();
    }

    private static void drawFigure(int sideLength, int TypeFigure) {
        TrueFigure trueFigure = null;
        switch (TypeFigure) {
            case 1 -> {
                trueFigure = new TrueFigure() {
                    final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
                    final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
                    final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

                    @Override
                    public void draw() {
                        String triangle = "";

                        for (int i = 0; i < sideLength; i++) {
                            for (int j = 0; j < sideLength - i; j++) {
                                triangle += " ";
                            }

                            triangle += TRIANGLE_LEFT_SIDE_ELEMENT;

                            for (int j = 0; j < i * 2; j++) {
                                triangle += " ";
                            }

                            triangle += TRIANGLE_RIGHT_SIDE_ELEMENT + "\n";
                        }

                        triangle += " ";

                        for (int i = 0; i < sideLength; i++) {
                            triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
                        }

                        System.out.println(triangle);
                    }
                };
            }
            case 2 -> {
                trueFigure = new TrueFigure() {
                    final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
                    final String RECTANGLE_VERTICAL_ELEMENT = "|";

                    @Override
                    public void draw() {

                        String horizontalLine = createHorizontalLine(sideLength);
                        String verticalLines = createVerticalLines(sideLength);

                        System.out.println(horizontalLine + verticalLines + horizontalLine);
                    }

                    private String createHorizontalLine(int length) {
                        String horizontalLine = " ";

                        for (int i = 0; i < length; i++) {
                            horizontalLine += RECTANGLE_HORIZONTAL_ELEMENT;
                        }

                        horizontalLine += " " + "\n";

                        return horizontalLine;
                    }

                    private String createVerticalLines(int length) {
                        String verticalLinesUnit = getVerticalLinesUnit(length);

                        String verticalLines = "";

                        for (int i = 0; i < length; i++) {
                            verticalLines += verticalLinesUnit;
                        }

                        return verticalLines;
                    }

                    private String getVerticalLinesUnit(int length) {
                        String verticalLinesUnit = RECTANGLE_VERTICAL_ELEMENT;

                        for (int i = 0; i < length; i++) {
                            verticalLinesUnit += " ";
                        }

                        verticalLinesUnit += RECTANGLE_VERTICAL_ELEMENT + "\n";

                        return verticalLinesUnit;
                    }

                };
            }
            default -> System.out.println("incorrect input");

        }

        if (trueFigure != null) {
            trueFigure.draw();
        }
    }
}