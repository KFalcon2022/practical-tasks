package com.walking.lesson12_counterAggregation.model;

public class Counter {
    public static final String GAS = "Газ";
    public static final String COLD_WATER = "Холодная вода";
    public static final String HOT_WATER = "Горячая вода";
    public static final String ELECTRIC = "Электричество";

    public static final String GAS_UNITS = "м^3";
    public static final String COLD_WATER_UNITS = "м^3";
    public static final String HOT_WATER_UNITS = "м^3";
    public static final String ELECTRIC_UNITS = "кВт*ч";

    private final String name;
    private int count;
    private final String units;

    public String getUnits() {
        return units;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public Counter(String name, int count, String units) {
        this.name = name;
        this.count = count;
        this.units = units;
    }

    public Counter(String name, String units) {
        this(name, 0, units);
    }

    public int incrementCounter() {
        return count++;
    }

    public void decrementCounter() {
        count--;
    }

    public void increaseCounter(int quantity) {
        count += quantity;
    }

    public void decreaseCounter(int quantity) {
        count -= quantity;
    }

}

