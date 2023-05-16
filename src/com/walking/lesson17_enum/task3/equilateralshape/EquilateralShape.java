package com.walking.lesson17_enum.task3.equilateralshape;

public enum EquilateralShape {
    SQUARE(1) {
        public static final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
        public static final String RECTANGLE_VERTICAL_ELEMENT = "|";
        @Override
        public String createShapeString(int length) {

            setLength(length);

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
    },
    EQUILATERALTRIANGLE(2) {
        public static final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
        public static final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
        public static final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";
        public String createShapeString(int length) {

            setLength(length);
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
    UNKNOWN(3){
        @Override
        public String createShapeString(int length) {
            return "Unknown";
        }
    };

    public static final String EMPTY_ELEMENT = " ";
    public static final String EMPTY_STRING = "";
    public static final char NEW_LINE_SYMBOL = '\n';

    private int shapeType;
    private static int length;

    EquilateralShape(int shapeType){
        this.shapeType = shapeType;
    }
    public abstract String createShapeString(int length);

    private static void setLength(int inLength){
        length = inLength;
    }

    public static EquilateralShape findGreetingType(int shapeType) {
//        Если параметр == null, возвращаем неизвестное сообщение, иначе при вызове equals()
//        в цикле будет вызвано исключение
        if (shapeType > 2) {
            return UNKNOWN;
        }

        for (EquilateralShape shape : EquilateralShape.values()) {
            if (shape.shapeType == shapeType) {
                return shape;
            }
        }
//        Если ничего не нашли - сообщение неизвестно для нашего енама
        return UNKNOWN;
    }


}
