package com.walking.lesson25_nested_classes.task1.static_class;

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

        EquilateralShape shape = new EquilateralShape(shapeType, length);
        System.out.println(shape.CreateShape());

    }


    private static class EquilateralShape {
        String EMPTY_ELEMENT = " ";
        String EMPTY_STRING = "";
        char NEW_LINE_SYMBOL = '\n';
        private final int type;
        private final int length;

        public EquilateralShape(int type, int length) {
            this.type = type;
            this.length = length;
        }

        public String CreateShape() {
            String shape = "";
            switch (type) {
                case 1:
                    Square square = new Square(length);
                    shape = square.createSquare();
                    break;
                case 2:
                    EquilateralTriangle triangle = new EquilateralTriangle(length);
                    shape = triangle.createTriangle();
                    break;
            }
            return shape;
        }

        private class Square {
            public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
            public static final String RECTANGLE_VERTICAL_ELEMENT = "|";

            private final int length;

            public Square(int length) {
                this.length = length;
            }

            public String createSquare() {
                String horizontalLine = createHorizontalLine(length);
                String verticalLines = createVerticalLines(length);

                return horizontalLine + verticalLines + horizontalLine;
            }

            private String createHorizontalLine(int length) {
                String horizontalLine = EMPTY_ELEMENT;

                for (int i = 0; i < length; i++) {
                    horizontalLine += RECTANGLE_HORIZONTAL_ELEMENT;
                }

                horizontalLine += EMPTY_ELEMENT + NEW_LINE_SYMBOL;

                return horizontalLine;
            }

            private String createVerticalLines(int length) {
                String verticalLinesUnit = getVerticalLinesUnit(length);

                String verticalLines = EMPTY_STRING;

                for (int i = 0; i < length; i++) {
                    verticalLines += verticalLinesUnit;
                }

                return verticalLines;
            }

            private String getVerticalLinesUnit(int length) {
                String verticalLinesUnit = RECTANGLE_VERTICAL_ELEMENT;

                for (int i = 0; i < length; i++) {
                    verticalLinesUnit += EMPTY_ELEMENT;
                }

                verticalLinesUnit += RECTANGLE_VERTICAL_ELEMENT + NEW_LINE_SYMBOL;

                return verticalLinesUnit;
            }
        }

        private class EquilateralTriangle {

            public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
            public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
            public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";


            private final int length;

            public EquilateralTriangle(int length) {
                this.length = length;
            }

            public int getLength() {
                return length;
            }

            public String createTriangle() {
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

                triangle += " ";

                for (int i = 0; i < length; i++) {
                    triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
                }

                return triangle;
            }
        }
    }
}