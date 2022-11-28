package com.walking.lesson17_enum.task3.shape;

//Напоминаю, что данная задача призвана лишь продемонстрировать возможности енама.
//В Java-разработке не принято использовать эту функциональность перечисляемых типов.
//Если у вас появилась необходимость использовать {} по отношению к элементу енама -
//вы допустили ошибку в проектировании вашей системы
public enum EquilateralShapeType {
    EQUILATERAL_TRIANGLE {
        private static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
        private static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
        private static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

        @Override
        public String createShapeString(int length) {
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
    },
    SQUARE {
        private static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
        private static final String RECTANGLE_VERTICAL_ELEMENT = "|";

        @Override
        public String createShapeString(int length) {
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

    //    Объявлять константы уровня класса в енаме - тоже плохая практика.
//    Это может запутать при использовании кода из-за схожего принципа именования.
    private static final String EMPTY_ELEMENT = " ";
    private static final String EMPTY_STRING = "";
    private static final char NEW_LINE_SYMBOL = '\n';

    //    Как видите, в енаме можно создать абстрактный метод. При условии, что его реализуют все элементы енама
    public abstract String createShapeString(int length);
}
