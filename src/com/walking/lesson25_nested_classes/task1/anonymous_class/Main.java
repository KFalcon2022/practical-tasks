package com.walking.lesson25_nested_classes.task1.anonymous_class;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
 */
public class Main {
    //    Поскольку классы-наследники анонимные, странно объявлять в них константы.
//    Константы во вложенных классах почти всегда выглядят сомнительным решением.
//    Даже если они нужны - стоит объявить их в основном классе. Или вынести в отдельный класс
//    с константами, если планируется часто их переиспользовать
    public static final String SQUARE_HORIZONTAL_ELEMENT = "-";
    public static final String SQUARE_VERTICAL_ELEMENT = "|";
    public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
    public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
    public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

//        В этом и других вариантах Задачи 1 при определении невалидных данных
//        используется RuntimeException, а не создается собственный потомок этого класса.
//        В целом, это допустимо, если в вашем приложении отсутствует отдельное архитектурное решение
//        для обработки исключений. И если вам не нужно хранить в исключениях дополнительные поля
        if (length < 1) {
//            Заодно закроем scanner, т.к. до штатного закрытия код не дойдет
            scanner.close();
            throw new RuntimeException("Incorrect shape's length input");
        }

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();

        scanner.close();

        String shapeString = createShapeString(length, shapeType);
        System.out.println(shapeString);
    }

    private static String createShapeString(int length, int type) {
        EquilateralShape shape;

        switch (type) {
            case 1:
                shape = createSquare(length);
                break;
            case 2:
                shape = createEquilateralTriangle(length);
                break;
            default:
                throw new RuntimeException("Unknown shape");
        }

        return shape.createShapeString();
    }

    //    Для улучшения читабельности кода вынесем создание объекта анонимного класса в отдельный метод
    private static EquilateralShape createSquare(int length) {
        return new EquilateralShape() {

            @Override
            public int getLength() {
                return length;
            }

            @Override
            public String createShapeString() {
                String horizontalLine = createHorizontalLine(length);
                String verticalLines = createVerticalLines(length);

                return horizontalLine + verticalLines + horizontalLine;
            }

            private String createHorizontalLine(int length) {
                String horizontalLine = EMPTY_ELEMENT;

                for (int i = 0; i < length; i++) {
                    horizontalLine += SQUARE_HORIZONTAL_ELEMENT;
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
                String verticalLinesUnit = SQUARE_VERTICAL_ELEMENT;

                for (int i = 0; i < length; i++) {
                    verticalLinesUnit += EMPTY_ELEMENT;
                }

                verticalLinesUnit += SQUARE_VERTICAL_ELEMENT + NEW_LINE_SYMBOL;

                return verticalLinesUnit;
            }
        };
    }

    private static EquilateralShape createEquilateralTriangle(int length) {
        return new EquilateralShape() {
            @Override
            public int getLength() {
                return length;
            }

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

                triangle += " ";

                for (int i = 0; i < length; i++) {
                    triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
                }

                return triangle;
            }
        };
    }
}
