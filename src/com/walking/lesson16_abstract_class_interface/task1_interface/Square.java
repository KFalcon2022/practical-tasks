package Lesson16.Task1.interfaces;

public class Square extends rightShape implements drowable{
    private static String widthLine = "";
    private static String lengthLine = "";
    public Square(int length)
    {
        super(length);
    }

    public final void draw()
    {
        if (length >= 0)
        {
            heightFiller();
            System.out.println(widthLine);
            System.out.println(StringCalculator(super.getLength()));
            System.out.println(widthLine);
        }
    }
    private String StringCalculator(int length)
    {
        int lengthCalculate;
        if (length > 2)
        {
            lengthCalculate = length - 2;
        }
        else
            lengthCalculate = length - 1;
        return (lengthFiller(lengthCalculate));
    }
    private void heightFiller()
    {
        if (this.length > 0)
        {
            for (int i = 0; i < length; i++)
            {
                this.widthLine += HORIZONTAL_LINE;
            }
        }
        else
            System.out.println("Width error");
    }
    private String lengthFiller( int lengthCounter)
    {
        if (lengthCounter == 0)
            return lengthLine;
        else {
            for (int i = 0; i < length; i++) {
                if (i == length - 1 || i == 0)
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
