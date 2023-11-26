package Lesson20.Task2;

public final class EquilateralTriangle extends EquilateralShape implements drowable {
    private int calculatedLength = 1;
    public EquilateralTriangle(byte length)
    {
        super(length);
        draw();
    }
    private void draw()
    {
        heightFiller();
        System.out.println(lengthFiller());
    }
    protected String heightFiller()
    {
            String emptyIn = "";
            String emptyOut = "";
            if (calculatedLength > 1) {
                emptyIn += EMPTY_ELEMENT.repeat((calculatedLength-1)/2);
                emptyIn += VERTICAL_LINE;
                emptyIn += EMPTY_ELEMENT.repeat((calculatedLength-1)/2);
            }
            if ((length/2 - ((calculatedLength+1)/2)) >= 0)
                emptyOut = EMPTY_ELEMENT.repeat(length/2 - ((calculatedLength+1)/2));
            System.out.println(emptyOut + LEFT_ANGLE + emptyIn + RIGHT_ANGLE);

            if (calculatedLength < length)
            {
                calculatedLength += 1;
                return heightFiller();
            }
            else return null;
    }
    protected String lengthFiller()
    {
        String bottomLine = "";
        for (int i = 0; i < length; i++)
        {
            bottomLine += HORIZONTAL_UNDERLINE;
        }
        return bottomLine;
    }
}
