package com.walking.lesson19_object_methods;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Car[] cars = new Car[]{
                new Car("Lada", "Vesta", "red", 502),
                new Car("Audi", "A4", "grey", 834),
                new Car("Mercedes","E-class", "black", 111),
                new Car("Lada", "Vesta", "red", 462),
                new Car("Hyundai", "Solaris", "yellow", 834)
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

        Car car = new Car(brand, model, color, number);
        System.out.println(car.compareCars(cars));
    }
}
