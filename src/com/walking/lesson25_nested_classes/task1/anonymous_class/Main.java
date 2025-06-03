package com.walking.lesson25_nested_classes.task1.anonymous_class;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
 */
public class Main {
    private static final String HORIZONTAL_SYMBOL = "-";
    private static final String VERTICAL_SYMBOL = "|";
    private static final String LEFT_SIDE_SYMBOL = "/";
    private static final String RIGHT_SIDE_SYMBOL = "\\";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter side length: ");
        int sideLength = scanner.nextInt();

        if (sideLength < 1) {
            scanner.close();
            throw new RuntimeException("Side length must be greater than 0");
        }

        System.out.println("Select a shape:\n1. square\n2. triangle");
        int selectedShape = scanner.nextInt();

        scanner.close();

        String shapeString = createShapeString(sideLength, selectedShape);
        System.out.println(shapeString);
    }

    private static String createShapeString(int sideLength, int selectedShape) {
        EquilateralShape equilateralShape = switch (selectedShape) {
            case 1 -> createSquare(sideLength);
            case 2 -> createEquilateralTriangle(sideLength);
            default -> throw new RuntimeException("Invalid shape");
        };

        return equilateralShape.createShapeString();
    }

    private static EquilateralShape createSquare(int sideLength) {
        return new EquilateralShape() {
            @Override
            public int getSideLength() {
                return sideLength;
            }

            @Override
            public String createShapeString() {
                String horizontalUnit = createHorizontalLine(sideLength);
                String verticalUnit = createVerticalLine(sideLength);

                return horizontalUnit + verticalUnit + horizontalUnit;
            }

            private String createHorizontalLine(int sideLength) {
                String horizontalLine = SPACE_SYMBOL;

                for (int i = 0; i < sideLength; i++) {
                    horizontalLine += HORIZONTAL_SYMBOL;
                }

                return horizontalLine + SPACE_SYMBOL + NEXT_LINE;
            }

            private String createVerticalLine(int sideLength) {
                String verticalLineUnit = EMPTY_STRING;

                for (int i = 0; i < sideLength; i++) {
                    verticalLineUnit += getVerticalLineUnit(sideLength);
                }

                return verticalLineUnit;
            }

            private String getVerticalLineUnit(int sideLength) {
                String verticalLine = VERTICAL_SYMBOL;

                for (int i = 0; i < sideLength; i++) {
                    verticalLine += SPACE_SYMBOL;
                }

                return verticalLine + VERTICAL_SYMBOL + NEXT_LINE;
            }
        };
    }

    private static EquilateralShape createEquilateralTriangle(int sideLength) {
        return new EquilateralShape() {
            @Override
            public int getSideLength() {
                return sideLength;
            }

            @Override
            public String createShapeString() {
                String twoSide = getLefElement(sideLength);
                String thirdSide = getHorizontalElement(sideLength);

                return twoSide + thirdSide;
            }

            private String getLefElement(int sideLength) {
                String leftElement = EMPTY_STRING;

                for (int i = 0; i < sideLength; i++) {

                    for (int j = sideLength - (i + 1); j > 0; j--) {
                        leftElement += SPACE_SYMBOL;
                    }

                    leftElement += LEFT_SIDE_SYMBOL + getRightElement(i) + NEXT_LINE;
                }

                return leftElement;
            }

            private String getRightElement(int index) {
                String rightElement = EMPTY_STRING;

                for (int i = 0; i < index * 2; i++) {
                    rightElement += SPACE_SYMBOL;
                }

                return rightElement + RIGHT_SIDE_SYMBOL;
            }

            private String getHorizontalElement(int sideLength) {
                String horizontalElement = EMPTY_STRING;

                for (int i = 0; i < sideLength * 2; i++) {
                    horizontalElement += HORIZONTAL_SYMBOL;
                }

                return horizontalElement;
            }
        };
    }
}
