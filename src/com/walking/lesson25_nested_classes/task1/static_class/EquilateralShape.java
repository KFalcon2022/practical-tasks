package com.walking.lesson25_nested_classes.task1.static_class;


public class EquilateralShape {
    //    Поля интерфейса - всегда public static final
    String EMPTY_ELEMENT = " ";
    String EMPTY_STRING = "";
    char NEW_LINE_SYMBOL = '\n';

    //    Мы не можем определить поле length в интерфейсе, но может указать, что каждый наследник обязан
//    определить поведение метода по получению значения length
    int getLength(){
        return 0;
    };

    String createShapeString(int type, int length){
        if (type == 1){
            return new Square(length).createShapeString();
        } else {
            return new EquilateralTriangle(length).createShapeString();
        }
    };


    public static class EquilateralTriangle extends EquilateralShape {
        //    За единицу у основания принято "--" для минимально удобоваримой визуализации
        public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
        public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
        public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";

        //    Поскольку интерфейс не позволяет создавать поля, кроме констант, мы вынуждены дублировать поле
//    length для каждого наследника. Либо вынести его в абстрактный класс, который будет
//    находиться между интерфейсом и конечными реализациями.
        private final int length;

        public EquilateralTriangle(int length) {
            this.length = length;
        }

        @Override
        public int getLength() {
            return length;
        }


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
    }

    public static class Square extends EquilateralShape {
        public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
        public static final String RECTANGLE_VERTICAL_ELEMENT = "|";

        private int length;

        public Square(int length){
            this.length = length;
        }

        @Override
        public int getLength() {
            return length;
        }


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
    }

}
