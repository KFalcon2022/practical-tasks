package Lesson20.Task3;

public class ArrayValidationException extends NullPointerException {
    public ArrayValidationException(String message, int index)
    {
        super(message + " Animal is null at [" + index + "]");
    }
}
