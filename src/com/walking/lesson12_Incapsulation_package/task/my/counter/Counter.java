package com.walking.lesson12_Incapsulation_package.task.my.counter;


public class Counter {
    private final String name;

    private int counter;

    private final String measuringUnit;

    public Counter(String name, int counter, String measuringUnit) {
        this.name = name;
        this.counter = counter;
        this.measuringUnit = measuringUnit;
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public void increment() {
        ++this.counter;
    }

    public void increase(int value) {
        this.counter += value;
    }

    public void reset() {
        this.counter = 0;
    }
    // Не смог придумать, как сделать reset доступным только из CounterService((
}
