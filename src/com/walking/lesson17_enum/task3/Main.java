package com.walking.lesson17_enum.task3;


import java.util.Scanner;

/**
 * Реализуйте задачу https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1
 * <p>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */

/**
 * Реализуйте класс «Правильная фигура».
 * Для него создайте классы-наследники «Треугольник» и «Квадрат».
 * <p>
 * Пользователь должен иметь возможность ввести длину стороны и выбрать тип фигуры.
 * Программа должна нарисовать в консоли выбранную пользователем фигуру,
 * используя символы '-', '|', '/', '\'.
 * <p>
 * Обратите внимание, символ '\' в Java необходимо экранировать: '\\'.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();

        scanner.close();

//        Корректнее валидировать значение сразу после ввода. Здесь проверка вынесена после
//        ради демонстрации ситуации, когда скобки в условном выражении действительно необходимы
        if (length < 1 || (shapeType != 1 && shapeType != 2)) {
            System.out.println("Incorrect input.");
        }

        EquilateralShape shape;

        if (shapeType == 2) {
            shape = EquilateralShape.EQUILATERALTRIANGLE;
            System.out.println(shape.create(length));
        } else {
            shape = EquilateralShape.SQUARE;
            System.out.println(shape.create(length));
        }
    }
}
    enum EquilateralShape {
        EQUILATERALTRIANGLE {
            public String create(int length) {
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
        },
        SQUARE {
            public String create(int length) {
                String horizontalLine = createHorizontalLine(length);
                String verticalLines = createVerticalLines(length);
                return horizontalLine + verticalLines + horizontalLine;
            }
        };

        public abstract String create(int length);

        public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
        public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
        public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";
        public static final String EMPTY_ELEMENT = " ";
        public static final String EMPTY_STRING = "";
        public static final char NEW_LINE_SYMBOL = '\n';
        public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
        public static final String RECTANGLE_VERTICAL_ELEMENT = "|";

        private static String createHorizontalLine(int length) {
            String horizontalLine = EMPTY_ELEMENT;

            for (int i = 0; i < length; i++) {
                horizontalLine += RECTANGLE_HORIZONTAL_ELEMENT;
            }
            horizontalLine += EMPTY_ELEMENT + NEW_LINE_SYMBOL;
            return horizontalLine;
        }

        private static String createVerticalLines(int length) {
            String verticalLinesUnit = getVerticalLinesUnit(length);
            String verticalLines = EMPTY_STRING;
            for (int i = 0; i < length; i++) {
                verticalLines += verticalLinesUnit;
            }
            return verticalLines;
        }

        private static String getVerticalLinesUnit(int length) {
            String verticalLinesUnit = RECTANGLE_VERTICAL_ELEMENT;
            for (int i = 0; i < length; i++) {
                verticalLinesUnit += EMPTY_ELEMENT;
            }
            verticalLinesUnit += RECTANGLE_VERTICAL_ELEMENT + NEW_LINE_SYMBOL;
            return verticalLinesUnit;
        }

    }
