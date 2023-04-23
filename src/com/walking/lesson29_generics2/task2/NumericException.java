package Lesson29.Task2;

public class NumericException extends NumberFormatException{
    public NumericException(String value)
    {
        super("Wrong pow number: " + value);
    }
}
