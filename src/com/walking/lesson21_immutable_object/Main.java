package com.walking.lesson21_immutable_object;

import com.walking.lesson21_immutable_object.model.Car;
import com.walking.lesson21_immutable_object.model.CarId;
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
        Car[] cars = new Car[]{new Car("kotov", 1,"red", false),
                               new Car("kotov", 2, "red", false),
                               new Car("kotov", 3, "red", true),
                               new Car("barsik", 1, "red", false),
                               new Car("barsik", 2, "red", false),
                               new Car("barsik", 3, "yellow", true),
                               new Car("furberg", 1, "yellow", true)
        };

        CarService carService = new CarService(cars);

     CarId targetCar = getCarIdFromUser();

    Car foundCar = carService.findCar(targetCar);

        if (foundCar != null) {
        System.out.println("Найдена машина:\n" + foundCar);
    } else {
        System.out.println("данная машина не найдена");
    }
}

    public static CarId getCarIdFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a car's owner");
        String owner = scanner.nextLine();

        System.out.println("Enter a car's identifier");
        int serialNumber = scanner.nextInt();
        scanner.nextLine();

        scanner.close();

        return new CarId(owner, serialNumber);
    }
}
