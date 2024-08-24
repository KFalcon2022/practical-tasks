package com.walking.lesson46_lambda.task3.model;

public class CarFilter {
    private final String name;
    private final String value;

    public CarFilter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
