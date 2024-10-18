package com.walking.lesson19_object_methods.model;

public class Car {
    private final int year;
    private final String number;
    private final String color;
    private final String model;
    private int hashcode;

    public Car (int year, String number, String color, String model) {
        this.year = year;
        this. number = number;
        this.color = color;
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public String getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals (Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != getClass()) {
            return false;
        }
        if (hashCode() != o.hashCode()) {
            return false;
        }

        Car carToCompare = (Car) o;
        return carToCompare.year == year && carToCompare.number.equals(number);
    }

    @Override
    public int hashCode() {
        if (hashcode == 0) {
            hashcode = year * 31;
            hashcode += number == null ? 0 : number.hashCode();
            hashcode += color == null ? 0 : color.hashCode();
            hashcode += model == null ? 0 : model.hashCode();
        }
    return hashcode;
    }

    @Override
    public String toString() {
        return color  + " " +
        model + " " +
        year  + ", " +
        number;
//порядок переменных выбран для более наглядного восприятия: "белая бмв 2000 года, номер ХХХ"
    }

}
