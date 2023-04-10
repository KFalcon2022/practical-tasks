package Lesson20.Task2;

public class ShapeException extends IllegalArgumentException {
    public ShapeException (String message, int number)
    {
        super(message + " Illegal argument is: [" + Integer.toString(number) + "]");
    }
}
