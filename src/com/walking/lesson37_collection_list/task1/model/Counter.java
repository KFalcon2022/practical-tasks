package com.walking.lesson37_collection_list.task1.model;

public class Counter {
    private final String NAME;
    private final String UNIT;

    private int value;

    public Counter(String NAME, String UNIT) {
        this(NAME, UNIT, 0);
    }

    public Counter(String NAME, String UNIT, int value) {
        this.NAME = NAME;
        this.UNIT = UNIT;
        this.value = value;
    }

    public String getNAME() {
        return NAME;
    }

    public String getUNIT() {
        return UNIT;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void getInfo() {
        System.out.printf("%s: %d %s%n", NAME, value, UNIT);
    }
}
