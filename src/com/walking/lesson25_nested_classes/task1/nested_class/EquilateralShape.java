package Lesson25.Task1.InnerClass;

public class EquilateralShape {
    private int length;
    public void quickDraw(String userChoice, int length)
    {
        setLength(length);
        validateChoice(userChoice);
    }
    private void setLength(int userLength)
    {
        if (userLength >= Byte.MAX_VALUE || userLength <= 1) throw new ShapeNumberException(length);
        length = userLength;
    }

    private void validateChoice(String userChoice)
    {
        if (!(userChoice.contains("tria") || userChoice.contains("sqa"))) throw new ShapeException(userChoice);
        if (userChoice.contains("tria")) {
            Triangle triangle = new Triangle(length);
            triangle.drawShape();
        }
        else {
            Square square = new Square(length);
            square.drawShape();
        }
    }
    public class Triangle implements Drowable {
        public Triangle(int length)
        {
            setLength(length);
        }
        private void setLength(int userLength)
        {
            if (userLength >= Byte.MAX_VALUE || userLength <= 0) throw new ShapeNumberException(length);
            length = userLength;
        }
        public int getLength()
        {
            return length;
        }
        public void drawShape()
        {
            System.out.println(CreateStringShape());
        }
        private String CreateStringShape()
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

    public class Square implements Drowable {
        private static String lengthLine = "";
        public Square(int length)
        {
            setLength(length);
        }
        private void setLength(int userLength)
        {
            if (userLength >= Byte.MAX_VALUE || length <= 1) throw new ShapeNumberException(userLength);
            length = userLength;
        }
        public int getLength()
        {
            return length;
        }
        public void drawShape()
        {
            System.out.println(CreateStringShape());
        }
        private String CreateStringShape()
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
