package Lesson20.Task3;

import java.util.NoSuchElementException;

public class UnknownAnimalException extends NoSuchElementException {
    public UnknownAnimalException(String message, Object obj)
    {
        super(message +": " + obj.toString());
    }
}
