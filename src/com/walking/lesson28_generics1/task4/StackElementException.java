package Lesson28.Task4;

public class StackElementException extends NullPointerException {
    public StackElementException(Object obj)
    {
        super ("End of elements, head is: " + obj);
    }
}
