package com.walking.lesson38_comparing.task1.model;

import java.util.Comparator;

public class Car implements Comparator<Car> {
    private final String number;
    private final String color;
    private final int year;

    public Car(String number, String color, int year) {
        this.number = number;
        this.color = color;
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compare(Car o1, Car o2) {
        return o1.number.compareTo(o2.number);
    }

    @Override
    public String toString() {
        return String.format("%s; %d; %s", number, year, color);
    }
}
