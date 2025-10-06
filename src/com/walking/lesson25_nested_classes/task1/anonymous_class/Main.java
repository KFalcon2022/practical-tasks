package com.walking.lesson25_nested_classes.task1.anonymous_class;

import com.walking.lesson25_nested_classes.task1.anonymous_class.model.EquilateralShapeCreateble;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();

        scanner.close();

        if (length < 1 || (shapeType != 1 && shapeType != 2)) {
            System.out.println("Incorrect input.");
            return;
        }

        String shapeString = createShapeString(length, shapeType);
        System.out.println(shapeString);
    }

    private static String createShapeString(int length, int type) {
        EquilateralShapeCreateble shape;

        switch (type) {
            case 1:
                shape = new EquilateralShapeCreateble() {
                    //    За единицу у основания принято "--" для минимально удобоваримой визуализации
                    public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
                    public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
                    public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";


                    //    Предлагаю особо не углубляться в способ отрисовки, он не критичен - задача направлена на
//    овладевание переопределением, а не псевдографикой
                    @Override
                    public String createShapeString() {
                        String triangle = EMPTY_STRING;

                        for (int i = 0; i < length; i++) {
                            for (int j = 0; j < length - i; j++) {
                                triangle += EMPTY_ELEMENT;
                            }

                            triangle += TRIANGLE_LEFT_SIDE_ELEMENT;

                            for (int j = 0; j < i * 2; j++) {
                                triangle += EMPTY_ELEMENT;
                            }

                            triangle += TRIANGLE_RIGHT_SIDE_ELEMENT + NEW_LINE_SYMBOL;
                        }

                        triangle += EMPTY_ELEMENT;

                        for (int i = 0; i < length; i++) {
                            triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
                        }

                        return triangle;
                    }

                    @Override
                    public int getLength() {
                        return length;
                    }
                };
                break;
            case 2:
                shape = new EquilateralShapeCreateble() {
                    public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
                    public static final String RECTANGLE_VERTICAL_ELEMENT = "|";

                    @Override
                    public String createShapeString() {
                        String horizontalLine = createHorizontalLine();
                        String verticalLines = createVerticalLines();

                        return horizontalLine + verticalLines + horizontalLine;
                    }

                    @Override
                    public int getLength() {
                        return length;
                    }

                    private String createHorizontalLine() {
                        String horizontalLine = EMPTY_ELEMENT;

                        for (int i = 0; i < length; i++) {
                            horizontalLine += RECTANGLE_HORIZONTAL_ELEMENT;
                        }

                        horizontalLine += EMPTY_ELEMENT + NEW_LINE_SYMBOL;

                        return horizontalLine;
                    }

                    private String createVerticalLines() {
                        String verticalLinesUnit = getVerticalLinesUnit();

                        String verticalLines = EMPTY_STRING;

                        for (int i = 0; i < length; i++) {
                            verticalLines += verticalLinesUnit;
                        }

                        return verticalLines;
                    }

                    private String getVerticalLinesUnit() {
                        String verticalLinesUnit = RECTANGLE_VERTICAL_ELEMENT;

                        for (int i = 0; i < length; i++) {
                            verticalLinesUnit += EMPTY_ELEMENT;
                        }

                        verticalLinesUnit += RECTANGLE_VERTICAL_ELEMENT + NEW_LINE_SYMBOL;

                        return verticalLinesUnit;
                    }
                };
                break;
            default:
                return "Unknown shape";
        }

        return shape.createShapeString();
    }
}
