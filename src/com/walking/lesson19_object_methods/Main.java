package com.walking.lesson19_object_methods;

import com.walking.lesson19_object_methods.model.Car;
import com.walking.lesson19_object_methods.service.CarService;

import java.util.Scanner;

/**
 * Реализуйте класс «Машина». Поля допустимо выбрать на свое усмотрение, но необходимо,
 * чтобы по ним можно было однозначно идентифицировать каждую машину.
 * Скажем, в рамках базы ГАИ.
 * <p>
 * Создайте массив машин. Реализуйте максимально эффективную проверку на вхождение машины в ваш массив.
 * Данные для проверки необходимо запрашивать с клавиатуры.
 * <p>
 * Если машина найдена — выведите ее строковое представление в консоль.
 * <p>
 * Опциональное усложнение: номер машины может быть не уникальным.
 */
public class Main {
    public static void main(String[] args) {
        Car[] cars = new Car[]{new Car("kotov", 1, "red", false),
                               new Car("kotov", 2, "red", false),
                               new Car("kotov", 3, "red", true),
                               new Car("barsik", 1, "red", false),
                               new Car("barsik", 2, "red", false),
                               new Car("barsik", 3, "yellow", true),
                               new Car("furberg", 1, "yellow", true)
        };

        CarService carService = new CarService(cars);

        Car targetCar = getCarFromUser();

        Car foundCar = carService.findCar(targetCar);

        if (foundCar != null) {
            System.out.println("Найдена машина:\n" + foundCar);
        } else {
            System.out.println("данная машина не найдена");
        }
    }

    public static Car getCarFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a car's owner");
        String owner = scanner.nextLine();

        System.out.println("Enter a car's identifier");
        int identifier = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter a car's color");
        String color = scanner.nextLine();

        System.out.println("Car is there a fine?");
        boolean hasFine = scanner.nextBoolean();

        scanner.close();

        return new Car(owner, identifier, color, hasFine);
    }
}
