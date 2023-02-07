package com.walking.lesson43.Task2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Car> cars = new HashMap<>();
        PutEntry(cars, "AD458D", "Vasya");
        PutEntry(cars, "JD434H", "Petya");
        PutEntry(cars, "MK323V", "Olya");
        PutEntry(cars, "AF043L", "Galya");

        Scanner scanner = new Scanner(System.in);
        String testNumber = scanner.next();
        scanner.close();

        if (cars.containsKey(testNumber)) {
            System.out.println("Car found: " + cars.get(testNumber));
        } else {
            System.out.println("no such car");
        }
    }

    public static void PutEntry(Map cars, String number, String owner) {
        cars.put(number, new Car(number, owner));
    }
}
