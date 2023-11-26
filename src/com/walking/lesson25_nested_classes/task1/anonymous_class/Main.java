package com.walking.lesson25_nested_classes.task1.anonymous_class;
import com.walking.lesson25_nested_classes.task1.anonymous_class.model.EquilateralShape;
import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) throws RuntimeException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter shape's type:\n 1: Square\n 2: Triangle\n");
        int shapeType = scanner.nextInt();

        scanner.close();

        if (length < 1 || (shapeType != 1 && shapeType != 2)) {
            throw new RuntimeException("Incorrect selected shape or length! Allowed length of side >1 and shape type \"1\" or \"2\"."+
                    " You entered is: Length: " + length +  " and shape type: " + shapeType);
        }
            EquilateralShape square = new EquilateralShape() {
                public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
                public static final String RECTANGLE_VERTICAL_ELEMENT = "|";
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
            };
            EquilateralShape triangle = new EquilateralShape() {
                public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
                public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
                public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";
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

            if (shapeType == 1){
                System.out.println(square.createShapeString());
            }else{
                System.out.println(triangle.createShapeString());
            }

        }
}