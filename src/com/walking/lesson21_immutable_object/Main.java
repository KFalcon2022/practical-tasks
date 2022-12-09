package com.walking.lesson21_immutable_object;

import com.walking.lesson21_immutable_object.model.Car;
import com.walking.lesson21_immutable_object.model.ImmutableCharacteristics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Car[] cars = new Car[]{
                new Car(new ImmutableCharacteristics("Lada", "Vesta"), "red", 502),
                new Car(new ImmutableCharacteristics("Audi", "A4"), "grey", 834),
                new Car(new ImmutableCharacteristics("Mercedes","E-class"), "black", 111),
                new Car(new ImmutableCharacteristics("Lada", "Vesta"), "red", 462),
                new Car(new ImmutableCharacteristics("Hyundai", "Solaris"), "yellow", 834)
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter car brand: ");
        String brand = scanner.next();
        System.out.println("Enter car model: ");
        String model = scanner.next();
        System.out.println("Enter car color: ");
        String color = scanner.next();
        System.out.println("Enter car number: ");
        int number = scanner.nextInt();
        scanner.close();

        Car car = new Car(new ImmutableCharacteristics(brand, model), color, number);
        System.out.println(findCar(cars, car));
    }

    private static Car findCar(Car[] cars, Car car) {
        for (Car c : cars) {
            if (c.equals(car)) {
                System.out.println("The car is in the database");

                return c;
            }
        }
        System.out.println("The car is not in the database");

        return null;
    }
}
