package com.walking.lesson21_immutable_object.service;

import com.walking.lesson21_immutable_object.model.Car;
import java.util.Scanner;

public class CarService {
    private Car car;
    private Car[] cars;

    public Car foundCarInput(Scanner scanner){
        System.out.println("Enter car parameters for the database search:");
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("License plate: ");
        String licensePlate = scanner.nextLine();
        return new Car(brand, model, color, licensePlate);
    }

    public void findCar(Car foundCar, Car[] cars) {
        boolean found = false;
        for (Car car : cars) {
            if (car.equals(foundCar)) {
                System.out.println("Car was found in the database " + foundCar);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Car was not found in the database.");
        }
    }
}
