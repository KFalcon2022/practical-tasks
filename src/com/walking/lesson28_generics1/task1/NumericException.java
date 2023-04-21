package Lesson28.Task1;

public class NumericException extends NumberFormatException{
    public NumericException(int value)
    {
        super("Wrong pow number: " + value);
    }
}
