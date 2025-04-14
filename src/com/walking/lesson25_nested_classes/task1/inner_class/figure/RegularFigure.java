package com.walking.lesson25_nested_classes.task1.inner_class.figure;

public class RegularFigure {
    // как я поняла, у интерфейса внутренние классы статик по умолчанию, поэтому тут заменила интерфейс на класс

    private final String SPACE = " ";
    private final String NEXT_LINE_SYMBOL = "\n";
    private final String HORIZONTAL = "-";
    private final String VERTICAL = "|";
    private final String RIGHT_SIDE = "\\";
    private final String LEFT_SIDE = "/";
    private final String BOTTOM_SIDE = "_";

    public final Square square;
    public final Triangle triangle;

    public RegularFigure (int length) {
        square = new Square(length);
        triangle = new Triangle(length);
    }

    public class Square {
        private final int length;
        private Square(int length) {
            this.length = length;
        }

        public String getFigure() {
            String square = getHorizontalSide();
            for (int i = 0; i < length - 2; i++) {
                square += getVerticalSide();
            }
            return square + getHorizontalSide();
        }

        private String getHorizontalSide() {
            return SPACE + HORIZONTAL.repeat(length - 2) + SPACE + NEXT_LINE_SYMBOL;
        }

        private String getVerticalSide() {
            return VERTICAL + SPACE.repeat(length - 2) + VERTICAL + NEXT_LINE_SYMBOL;
        }
    }

    public class Triangle {
        private final int length;
        private Triangle(int length) {
            this.length = length;
        }

        public String getFigure() {
            return getTriangle() + getBottomSide();
        }

        private String getBottomSide() {
            return LEFT_SIDE + BOTTOM_SIDE.repeat(length) + RIGHT_SIDE;
        }

        private String getTriangle() {
            int k = length / 2;
            int j = length % 2;

            String triangle = "";
            for (int i = 0; i < length / 2; i++) {
                triangle += SPACE.repeat(k) + LEFT_SIDE + SPACE.repeat(j) + RIGHT_SIDE + NEXT_LINE_SYMBOL;
                k--;
                j += 2;
            }

            return triangle;
        }
    }
}
