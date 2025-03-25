package com.walking.lesson17_enum.task3.figure;


public enum RegularFigure {
    TRIANGLE("треугольник"){
        public String getFigure() {
            int k = getLength() / 2;
            int j = getLength() % 2;

            String triangle = "";
            for (int i = 0; i < getLength() / 2; i++) {
                triangle += SPACE.repeat(k) + LEFT_SIDE_TRIANGLE + SPACE.repeat(j) + RIGHT_SIDE_TRIANGLE + NEXT_LINE;
                k--;
                j += 2;
            }

            triangle += LEFT_SIDE_TRIANGLE + HORIZONTAL_SIDE.repeat(getLength()) + RIGHT_SIDE_TRIANGLE;
            return triangle;
        }
    },

    SQUARE("квадрат") {
        public String getFigure() {
            String square = SPACE + HORIZONTAL_SQUARE.repeat(getLength() - 2) + SPACE + NEXT_LINE;
            for (int i = 0; i < getLength() - 2; i++) {
                square += VERTICAL_SQUARE + SPACE.repeat(getLength() - 2) + VERTICAL_SQUARE + NEXT_LINE;
            }
            square += SPACE + HORIZONTAL_SQUARE.repeat(getLength() - 2) + SPACE + NEXT_LINE;
            return square;
        }
    },

    UNKNOWN(null) {
        public String getFigure() {
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

    private int length;

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

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    public abstract String getFigure();
}
