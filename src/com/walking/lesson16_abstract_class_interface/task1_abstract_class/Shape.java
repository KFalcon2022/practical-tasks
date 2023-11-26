package Lesson16.Task1.abstr;

public abstract class Shape {
    private int length = 1;
    protected static final String HORIZONTAL_LINE = "-";
    protected static final String VERTICAL_LINE = "|";
    protected static final String EMPTY_ELEMENT = " ";
    protected static final String ENTER_NEW_LINE = "\n";
    protected Shape()
    {

    }

    protected Shape(int length)
    {
        if (length > 0 && length <= Integer.MAX_VALUE)
        {
            this.length = length;
        }
        else
        {
            System.out.println("Error, wrong length");
        }
    }
    protected int getLength()
    {
        return length;
    }
    protected abstract void draw();
}
