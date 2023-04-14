package Lesson25.Task1.StaticInner;

import Lesson25.Task1.InnerClass.ShapeException;

public class EquilateralShape {
    private static int length;
    public EquilateralShape() {}

    public EquilateralShape(int UserLength, String figure)
    {
        setLength(UserLength);
        validateChoice(figure);
    }

    private void validateChoice(String figure)
    {
        if (!(figure.contains("tria") || figure.contains("sqa"))) throw new ShapeException(figure);
        if (figure.contains("tria")) {
            EquilateralShape.Triangle.drawShape(length);
        }
        else {
            Square.drawShape(length);
        }
    }
    private static void setLength(int userLength)
    {
        if (userLength >= Byte.MAX_VALUE || userLength <= 1) throw new ShapeNumberException(length);
        length = userLength;
    }
    //------------------------------------------------------------------------------------------------------------------
    public static class Triangle implements Drowable {
        @Override
        public int getLength() {
            return length;
        }

        public static String drawShape(int UserChoice) {
            setLength(UserChoice);
            return fillTriangle();
        }
        public static String fillTriangle()
        {
            String triangleString = "";
            for (int i = 0; i<length; i++)
            {
                triangleString += EMPTY_ELEMENT.repeat((Math.round((float) length-i)/2))
                        + LEFT_ANGLE
                        + EMPTY_ELEMENT.repeat(i)
                        + RIGHT_ANGLE
                        + EMPTY_ELEMENT.repeat((Math.round((float) length-i)/2)) + ENTER_NEW_LINE;
            }
            triangleString += HORIZONTAL_UNDERLINE.repeat(length);
            return triangleString;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public static class Square implements Drowable {

        @Override
        public int getLength() {
            return length;
        }

        static public String drawShape(int UserChoice) {
            setLength(UserChoice);
            return fillSquare();
        }
        private static String fillSquare()
        {
            String squareString = "";
            squareString += HORIZONTAL_LINE.repeat(length) + ENTER_NEW_LINE;
            for (int i = 0; i < length-2; i++)
            {
                squareString += VERTICAL_LINE + EMPTY_ELEMENT.repeat(length-2) + VERTICAL_LINE + ENTER_NEW_LINE;
            }
            squareString += HORIZONTAL_LINE.repeat(length) + ENTER_NEW_LINE;
            return squareString;
        }
    }
}
