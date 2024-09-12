package com.walking.lesson25_nested_classes.task1.staticclass.task1_interface;


import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя интерфейс.
 */
public class Main {
   static String EMPTY_ELEMENT = " ";
   static String EMPTY_STRING = "";
   static char NEW_LINE_SYMBOL = '\n';
    private static int length;


    private static String createShapeString(int length, int type) {


        switch (type) {
            case 1:

                return Square.createShapeString();

            case 2:

                return EquilateralTriangle.createShapeString();

            case 3:
            default:
                return "Unknown shape";
        }


    }

    private static class EquilateralTriangle  {
        //    За единицу у основания принято "--" для минимально удобоваримой визуализации
        public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
        public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
        public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

        //    Поскольку интерфейс не позволяет создавать поля, кроме констант, мы вынуждены дублировать поле
//    length для каждого наследника. Либо вынести его в абстрактный класс, который будет
//    находиться между интерфейсом и конечными реализациями.




        private static String createShapeString() {
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

    private static class Square  {
        public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
        public static final String RECTANGLE_VERTICAL_ELEMENT = "|";





        private static   String createShapeString() {
            String horizontalLine = createHorizontalLine(length);
            String verticalLines = createVerticalLines(length);

            return horizontalLine + verticalLines + horizontalLine;
        }

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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
         length = scanner.nextInt();

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
}
