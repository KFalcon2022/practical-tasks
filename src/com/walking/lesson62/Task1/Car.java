package com.walking.lesson62.Task1;

public class Car {
    public int number;
    public String operator;

    public Car(int number, String operator) {
        this.number = number;
        this.operator = operator;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int newNumber) {
        number = newNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void updateOperator(String operator) {
        this.operator += ", " + operator;
    }

    @Override
    public String toString() {
        return "Car ID: %d (%s)".formatted(number, operator);
    }
}
