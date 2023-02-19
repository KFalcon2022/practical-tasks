package com.walking.lesson49_optional.Task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Car> cars = new HashMap<>();
        putEntry(cars, "AD458D", "Vasya");
        putEntry(cars, "JD434H", "Petya");
        putEntry(cars, "MK323V", "Olya");
        putEntry(cars, "AF043L", "Galya");

        Scanner scanner = new Scanner(System.in);
        String testNumber = scanner.next();
        scanner.close();

        System.out.println(findCar(cars, testNumber));
    }

    public static void putEntry(Map cars, String number, String owner) {
        cars.put(number, new Car(number, owner));
        // А как его сделать неизбыточным?
        // Хранить номер как ключ мапы, а в машине вовсе не хранить? Вроде бы нет.
    }

    public static Optional<Car> findCar(Map<String, Car> cars, String number) {
        return Optional.ofNullable(cars.get(number));
    }
}
