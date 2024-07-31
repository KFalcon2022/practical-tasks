package com.walking.lesson25_nested_classes.task1.inner_class.model;

public class EquilateralShape {
    private static final String HORIZONTAL_SYMBOL = "-";
    private static final String VERTICAL_SYMBOL = "|";
    private static final String LEFT_SIDE_SYMBOL = "/";
    private static final String RIGHT_SIDE_SYMBOL = "\\";

    public String createShape(int sideLength, int selectedShape) {
        Shape shape = switch (selectedShape) {
            case 1 -> new Square(sideLength);
            case 2 -> new EquilateralTriangle(sideLength);
            default -> throw new RuntimeException("Invalid selected shape: " + selectedShape);
        };

        return shape.createShapeString();
    }

    public class Square implements Shape {
        private final int sideLength;

        public Square(int sideLength) {
            this.sideLength = sideLength;
        }

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
    }

    public class EquilateralTriangle implements Shape {
        private final int sideLength;

        public EquilateralTriangle(int sideLength) {
            this.sideLength = sideLength;
        }

        @Override
        public int getSideLength() {
            return sideLength;
        }

        @Override
        public String createShapeString() {
            String twoSide = getTwoSide(sideLength);
            String thirdSide = getHorizontalElement(sideLength);

            return twoSide + thirdSide;
        }

        private String getTwoSide(int sideLength) {
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
    }
}
