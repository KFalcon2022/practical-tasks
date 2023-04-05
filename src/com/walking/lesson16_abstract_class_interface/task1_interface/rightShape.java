package Lesson16.Task1.interfaces;

public class rightShape {
    protected final int length;
    protected rightShape(int length)
    {
        if ((length > 0 && length < Integer.MAX_VALUE)) {
            this.length = length;
        }
        else {
            this.length = 1;
            System.out.println("Wrong length");
        }
    }
    protected int getLength()
    {
        return length;
    }
}
