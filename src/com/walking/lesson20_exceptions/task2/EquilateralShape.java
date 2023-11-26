package Lesson20.Task2;

public abstract class EquilateralShape {
    int length;
    public EquilateralShape(byte length)
    {
        this.length = length;
    }

    protected abstract String heightFiller();
    protected abstract String lengthFiller();
}
