package Lesson25.Task1.Anonymous;

import java.util.NoSuchElementException;

public class ShapeException extends NoSuchElementException {
    public ShapeException(String message)
    {
        super("No such Shape :" + message);
    }
}
