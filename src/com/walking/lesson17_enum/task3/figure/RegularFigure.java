package com.walking.lesson17_enum.task3.figure;


public enum RegularFigure {
    TRIANGLE("треугольник"){
        @Override
        public String getFigure(int length) {
            int k = length / 2;
            int j = length % 2;

            String triangle = "";
            for (int i = 0; i < length / 2; i++) {
                triangle += SPACE.repeat(k) + LEFT_SIDE_TRIANGLE + SPACE.repeat(j) + RIGHT_SIDE_TRIANGLE + NEXT_LINE;
                k--;
                j += 2;
            }

            triangle += LEFT_SIDE_TRIANGLE + HORIZONTAL_SIDE.repeat(length) + RIGHT_SIDE_TRIANGLE;
            return triangle;
        }
    },

    SQUARE("квадрат") {
        @Override
        public String getFigure(int length) {
            String square = SPACE + HORIZONTAL_SQUARE.repeat(length - 2) + SPACE + NEXT_LINE;
            for (int i = 0; i < length - 2; i++) {
                square += VERTICAL_SQUARE + SPACE.repeat(length - 2) + VERTICAL_SQUARE + NEXT_LINE;
            }
            square += SPACE + HORIZONTAL_SQUARE.repeat(length - 2) + SPACE + NEXT_LINE;
            return square;
        }
    },

    UNKNOWN(null) {
        @Override
        public String getFigure(int length) {
            return "Неизвестная фигура";
        }
    };

    private static final String SPACE = " ";
    private static final String NEXT_LINE = "\n";
    private static final String RIGHT_SIDE_TRIANGLE = "\\";
    private static final String LEFT_SIDE_TRIANGLE = "/";
    private static final String HORIZONTAL_SIDE = "_";
    private static final String HORIZONTAL_SQUARE = "-";
    private static final String VERTICAL_SQUARE = "|";

    private final String name;

    RegularFigure(String name) {
        this.name = name;
    }

    public static RegularFigure getFigureByName(String name) {
        if (name == null) {
            return UNKNOWN;
        }

        for (RegularFigure figure : RegularFigure.values()) {
            if (name.toLowerCase().equals(figure.getName())) {
                return figure;
            }
        }

        return UNKNOWN;
    }

    public String getName() {
        return name;
    }

    public abstract String getFigure(int length);
}
