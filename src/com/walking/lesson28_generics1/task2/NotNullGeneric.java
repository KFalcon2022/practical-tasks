package Lesson28.Task2;

public class NotNullGeneric <T extends Object> {
    private final T object;
    public NotNullGeneric(T object)
    {
        this.object = notNull(object);
    }
    private T notNull(T object)
    {
        if (object instanceof Object && object!= null)
            return object;
        else throw new NullPointerException();
    }
    public T getObject()
    {
        return object;
    }
}
