package Lesson25.Task1.Anonymous;

public class EquilShape implements Drowable {
    private final int length;
    public EquilShape (int userLength)
    {
        length = validateLength(userLength);
    }

    private int validateLength(int userLength)
    {
        if (userLength >= Byte.MAX_VALUE || userLength <= 1)
            throw new ShapeNumberException(userLength);
        return userLength;
    }
    @Override
    public String drawShape()
    {
        throw new ShapeException("abstract Shape");
    }
}
