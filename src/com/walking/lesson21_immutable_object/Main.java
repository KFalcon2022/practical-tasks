package com.walking.lesson21_immutable_object;

import com.walking.lesson21_immutable_object.model.Car;
import com.walking.lesson21_immutable_object.service.CarService;

import java.util.Scanner;

/**
 * Реализуйте задачу из урока 19.
 * <p>
 * На свое усмотрение, вынесите неизменяемые поля,
 * используемые для идентификации и поиска машины в отдельный immutable класс
 * или сделайте весь класс «Машина» неизменяемым.
 * Правильный выбор зависит от набора полей, который существует в вашей текущей реализации класса «Машина».
 */
public class Main {
    public static void main(String[] args) {
        Car[] cars = new Car[]{
                new Car("MAZDA", "CX5", "RED", "X555CX95"),
                new Car("VOLVO", "CX70", "BLACK", "T222TT77"),
                new Car("NISSAN", "X-TRAIL", "GREY", "P420AK29"),
                new Car("CHEVROLET", "NIVA", "GREY", "H123AA51")};

        CarService carService = new CarService();

        Scanner scanner = new Scanner(System.in);
        Car foundCar = foundCarInput(scanner);
        scanner.close();

        if (carService.findCar(foundCar, cars)) {
            System.out.println("Car was found in the database " + foundCar);
        } else {
            System.out.println("Car was not found in the database.");
        }
    }

    public static Car foundCarInput(Scanner scanner) {
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
}
