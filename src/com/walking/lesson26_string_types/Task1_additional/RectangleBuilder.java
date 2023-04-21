package Lesson26.Task1_additional;

public class RectangleBuilder {
    private int length;
    private int width;
    private StringBuilder rectangle = new StringBuilder("");
    public RectangleBuilder (StringBuilder values)
    {
        parseStringValues(values);
        System.out.println(drawRectangle());
    }
    public RectangleBuilder (int length, int width)
    {
        validateValues(length, width);
        System.out.println(drawRectangle());
    }

    private void parseStringValues(StringBuilder values)
    {
        String strValues;
        int length;
        int width;
        strValues = values.toString().replace(".", " ")
                .replace("\\", " ")
                .replace("/", " ");
        String[] numericVal = strValues.split(" ");
        try {
            length = Integer.parseInt(numericVal[0]);
            width = Integer.parseInt(numericVal[1]);
            validateValues(length, width);
        }
        catch (Exception ex)
        {
            throw new ValuesException(values.toString(), ex.getMessage());
        }
    }

    private void validateValues(int length, int width)
    {
        if (length <= 2 || length >= Byte.MAX_VALUE || width <= 2 || width >= Byte.MAX_VALUE)
            throw new ValuesException(Integer.toString(length) + Integer.toString(width), "");
        this.length = length-2;
        this.width = width-2;
    }

    private StringBuilder drawRectangle()
    {
        drawHorizontalLine();
        drawVerticalLines();
        drawHorizontalLine();
        return rectangle;
    }
    private void drawHorizontalLine()
    {
        rectangle.append("|");
        for (int i = 0; i < length; i++)
        {
            rectangle.append("-");
        }
        rectangle.append("|\n");
    }
    private void drawVerticalLines()
    {
        for (int i = 0; i < width; i++)
        {
            rectangle.append("|");
            for (int j = 0; j < length; j++)
            {
                rectangle.append(" ");
            }
            rectangle.append("|\n");
        }
    }
}
