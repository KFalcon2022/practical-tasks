package Lesson17.Task3;

import java.util.List;

public enum EquilateralShape {
    Square
            {
                private static String lengthLine = "";
                public void setLength(int length) {
                    super.setLength(length);
                    draw();
                }
                public final void draw()
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
                    int lengthCalculate;
                    if (length > 2)
                    {
                        lengthCalculate = length - 2;
                    }
                    else
                        lengthCalculate = length - 1;
                    return (lengthFiller(lengthCalculate));
                }
                private String heightFiller()
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
                private String lengthFiller(int lengthCounter)
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
            },
    EquilateralTriangle
            {
                public void setLength(int length) {
                    super.setLength(length);
                    draw();
                }
                private void draw()
                {
                    drawAngles();
                    drawBottom();
                }
                private void drawAngles()
                {
                    for (int i = 1; i < length; i++)
                    {
                        String emptyIn = "";
                        String emptyOut = "";
                        if (i > 1) {
                            emptyIn += EMPTY_ELEMENT.repeat((i-1)/2);
                            emptyIn += VERTICAL_LINE;
                            emptyIn += EMPTY_ELEMENT.repeat((i-1)/2);
                        }
                        if ((length/2 - ((i+1)/2)) >= 0)
                        emptyOut = EMPTY_ELEMENT.repeat(length/2 - ((i+1)/2));
                        System.out.println(emptyOut + LEFT_ANGLE + emptyIn + RIGHT_ANGLE);
                    }
                }

                private void drawBottom()
                {
                    String bottomLine = "";
                    for (int i = 0; i < this.length; i++)
                    {
                        bottomLine += HORIZONTAL_TR_LINE;
                    }
                    System.out.println(bottomLine);
                }
            };

    int length;
    protected static final String HORIZONTAL_LINE = "-";
    protected static final String VERTICAL_LINE = "|";
    protected static final String EMPTY_ELEMENT = " ";
    protected static final String ENTER_NEW_LINE = "\n";
    private final static String RIGHT_ANGLE = "\\";
    private static final String LEFT_ANGLE = "/";
    protected static final String HORIZONTAL_TR_LINE = "_";
    public void setLength(int length)
    {
        if (length > 0 && length <= Integer.MAX_VALUE)
            this.length = length;
        else
            this.length = 1;
    }
    private void draw() {}
}
