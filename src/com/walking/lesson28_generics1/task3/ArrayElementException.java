package Lesson28.Task3;

public class ArrayElementException extends NullPointerException {
    public ArrayElementException(Object obj)
    {
        super ("No such Element: " + obj.toString());
    }
}
