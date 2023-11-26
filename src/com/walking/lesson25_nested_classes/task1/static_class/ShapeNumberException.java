package Lesson25.Task1.StaticInner;

public class ShapeNumberException extends NumberFormatException{
    public ShapeNumberException(int length)
    {
        super("Wrong length number :" + length);
    }
}
