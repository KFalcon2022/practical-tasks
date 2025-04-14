package com.walking.lesson25_nested_classes.task1.static_class.figure;

public interface RegularFigure {
    String SPACE = " ";
    String NEXT_LINE_SYMBOL = "\n";
    String HORIZONTAL = "-";
    String VERTICAL = "|";
    String RIGHT_SIDE = "\\";
    String LEFT_SIDE = "/";
    String BOTTOM_SIDE = "_";

    String getFigure(int length);

    class Square implements RegularFigure {
        public String getFigure(int length) {
            String square = getHorizontalSide(length);
            for (int i = 0; i < length - 2; i++) {
                square += getVerticalSide(length);
            }
            return square + getHorizontalSide(length);
        }

        private String getHorizontalSide(int length) {
            return SPACE + HORIZONTAL.repeat(length - 2) + SPACE + NEXT_LINE_SYMBOL;
        }

        private String getVerticalSide(int length) {
            return VERTICAL + SPACE.repeat(length - 2) + VERTICAL + NEXT_LINE_SYMBOL;
        }
    }

    class Triangle implements RegularFigure {
        public String getFigure(int length) {
            return getTriangle(length) + getBottomSide(length);
        }

        private String getBottomSide(int length) {
            return LEFT_SIDE + BOTTOM_SIDE.repeat(length) + RIGHT_SIDE;
        }

        private String getTriangle(int length) {
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

    class Unknown implements RegularFigure {
        public String getFigure(int length) {
            return "Неизвестная фигура";
        }
    }
}
