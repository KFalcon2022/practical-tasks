package Lesson29.Task2;

public class PowGen <T extends Number> {
    private T a;
    private T b;
    public PowGen(T a, T b) {
        validateNumbers(a, b);
    }
    private void validateNumbers(T a, T b) {
        if (a.doubleValue() == 0 || b.doubleValue() == 0) {
            throw new NumericException("0");
        }
        if ((Integer)a >= Byte.MAX_VALUE || (Integer)b >= Byte.MAX_VALUE) {
            throw new NumericException("too large");
        }
        this.a = a;
        this.b = b;
    }
    public Double pow() {
        return Math.pow(a.doubleValue(), b.doubleValue());
    }
}
