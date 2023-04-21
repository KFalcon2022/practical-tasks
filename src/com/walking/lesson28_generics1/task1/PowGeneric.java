package Lesson28.Task1;

public class PowGeneric<Integer> {
    private int value;
    public PowGeneric(Integer value)
    {
        this.value = (int) value;
    }
    private byte validatePow(byte pow)
    {
        if (pow > Byte.MAX_VALUE || pow < 1)
            throw new NumericException((int) pow);
        return pow;
    }
    public int getPow(byte pow)
    {
        byte validatedPow = validatePow(pow);
        for (int i=1; i<pow; i++)
        {
            value *= value;
        }
        return value;
    }
}
