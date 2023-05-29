
public class Counter {
    public final String name;
    public int counter;
    public final String unit;

    public Counter(String name, String unit) {
        this(name, 0, unit);
    }

    public Counter(String name, int counter, String unit) {
        this.counter = counter;
        this.name = name;
        this.unit = unit;
    }
}
