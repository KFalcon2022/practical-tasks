package lesson12_incapsulation.com.walking.counterAggregation;

public class Counter {
    public final String name;
    public final String unit;
    public int counter;

    public Counter(String name, String unit) {
        this(name, 0, unit);
    }

    public Counter(String name, int counter, String unit) {
        this.counter = counter;
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getCounter() {
        return counter;
    }

    void setCounter(int counter) {
        this.counter = counter;
    }
}
