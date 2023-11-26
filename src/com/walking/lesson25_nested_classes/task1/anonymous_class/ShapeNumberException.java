package Lesson25.Task1.Anonymous;

public class ShapeNumberException extends NumberFormatException{
    public ShapeNumberException(int length)
    {
        super("Wrong length number :" + length);
    }
}
