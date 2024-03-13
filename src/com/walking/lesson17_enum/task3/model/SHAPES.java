package com.walking.lesson17_enum.task3.model;

public enum SHAPES {
    SQUARE {
        public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
        public static final String RECTANGLE_VERTICAL_ELEMENT = "|";

        @Override
        public void draw(int sideLength) {
            String horizontalLine = createHorizontalLine(sideLength);
            String verticalLines = createVerticalLines(sideLength);

            System.out.println(horizontalLine + verticalLines + horizontalLine);
        }

        private String createHorizontalLine(int length) {
            String horizontalLine = " ";

            for (int i = 0; i < length; i++) {
                horizontalLine += RECTANGLE_HORIZONTAL_ELEMENT;
            }

            horizontalLine += " " + "\n";

            return horizontalLine;
        }

        private String createVerticalLines(int length) {
            String verticalLinesUnit = getVerticalLinesUnit(length);

            String verticalLines = "";

            for (int i = 0; i < length; i++) {
                verticalLines += verticalLinesUnit;
            }

            return verticalLines;
        }

        private String getVerticalLinesUnit(int length) {
            String verticalLinesUnit = RECTANGLE_VERTICAL_ELEMENT;

            for (int i = 0; i < length; i++) {
                verticalLinesUnit += " ";
            }

            verticalLinesUnit += RECTANGLE_VERTICAL_ELEMENT + "\n";

            return verticalLinesUnit;
        }
    },
    TRIANGLE {
        public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
        public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
        public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

        @Override
        public void draw(int sideLength) {
            String triangle = "";

            for (int i = 0; i < sideLength; i++) {
                for (int j = 0; j < sideLength - i; j++) {
                    triangle += " ";
                }

                triangle += TRIANGLE_LEFT_SIDE_ELEMENT;

                for (int j = 0; j < i * 2; j++) {
                    triangle += " ";
                }

                triangle += TRIANGLE_RIGHT_SIDE_ELEMENT + "\n";
            }

            triangle += " ";

            for (int i = 0; i < sideLength; i++) {
                triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
            }

            System.out.println(triangle);
        }
    };

    public abstract void draw(int sideLength);
}
