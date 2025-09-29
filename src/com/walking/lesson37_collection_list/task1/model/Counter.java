package com.walking.lesson37_collection_list.task1.model;

public class Counter {
    private final String name;
    private final String unit;

    private int value;

    public Counter(String NAME, String UNIT) {
        this(NAME, UNIT, 0);
    }

    public Counter(String NAME, String UNIT, int value) {
        this.name = NAME;
        this.unit = UNIT;
        this.value = value;
    }

    public String getNAME() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getInfo() {
        return "%s: %d %s%n".formatted(name, value, unit);
    }
}
