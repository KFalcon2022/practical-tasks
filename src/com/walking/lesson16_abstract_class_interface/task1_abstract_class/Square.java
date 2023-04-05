package Lesson16.Task1.abstr;

public class Square extends Shape {
    private static String widthLine = "";
    private static String lengthLine = "";
    public Square(int length)
    {
        super(length);
    }
    @Override
    public final void draw()
    {
        if (super.getLength() >= 0)
        {
            System.out.println(heightFiller());
            System.out.println(StringCalculator());
            System.out.println(heightFiller());
        }
    }
    private String StringCalculator()
    {
        int lengthCalculate;
        if (super.getLength() > 2)
        {
            lengthCalculate = super.getLength() - 2;
        }
        else
            lengthCalculate = super.getLength() - 1;
        return (lengthFiller(lengthCalculate));
    }
    private String heightFiller()
    {
        String widthLine = "";
        if (super.getLength() > 0)
        {
            for (int i = 0; i < super.getLength(); i++)
            {
                widthLine += HORIZONTAL_LINE;
            }
        }
        else
            System.out.println("Width error");
        return widthLine;
    }
    private String lengthFiller( int lengthCounter)
    {
        if (lengthCounter == 0)
            return lengthLine;
        else {
            for (int i = 0; i < super.getLength(); i++) {
                if (i == super.getLength() - 1 || i == 0)
                    lengthLine += VERTICAL_LINE;
                else
                    lengthLine += EMPTY_ELEMENT;
            }
            if (lengthCounter != 1)
            lengthLine += ENTER_NEW_LINE;
            return lengthFiller(lengthCounter-1);
        }
    }
}
