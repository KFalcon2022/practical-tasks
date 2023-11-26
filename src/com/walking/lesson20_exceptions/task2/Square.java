package Lesson20.Task2;

import Lesson16.Task1.abstr.Shape;

public final class Square extends EquilateralShape implements drowable {
    private static String lengthLine = "";
    private int calculatedLength;
    public Square (byte length)
    {
        super(length);
        draw();
    }
    public void draw()
    {
        if (length >= 0)
        {
            System.out.println(heightFiller());
            System.out.println(StringCalculator());
            System.out.println(heightFiller());
        }
    }
    private String StringCalculator()
    {
        if (length > 2)
        {
            calculatedLength = length - 2;
        }
        else
            calculatedLength = length - 1;
        return (lengthFiller());
    }
    protected String heightFiller()
    {
        String widthLine = "";
        if (length > 0)
        {
            for (int i = 0; i < length; i++)
            {
                widthLine += HORIZONTAL_LINE;
            }
        }
        else
            System.out.println("Width error");
        return widthLine;
    }
    protected String lengthFiller()
    {
        if (calculatedLength == 0)
            return lengthLine;
        else {
            for (int i = 0; i < length; i++) {
                if (i == length - 1 || i == 0)
                    lengthLine += VERTICAL_LINE;
                else
                    lengthLine += EMPTY_ELEMENT;
            }
            if (calculatedLength != 1)
                lengthLine += ENTER_NEW_LINE;
            calculatedLength -= 1;
            return lengthFiller();
        }
    }
}
