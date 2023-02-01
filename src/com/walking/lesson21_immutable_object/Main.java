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

    private static final Car[] CARS = new Car[]{
            new Car("11", "to", "1", 2000),
            new Car("11", "to", "1", 2000),
            new Car("33", "to", "3", 2002),
            new Car("44", "to", "4", 2003),
            new Car("44", "to", "5", 2000),
            new Car("44", "to", "5", 2000),
            new Car("44", "to", "5", 2000),
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input car's parameters for searching:");
        System.out.print("Registration plate:");
        String registrationPlate = sc.nextLine();
        System.out.print("Brand:");
        String brand = sc.nextLine();
        System.out.print("Model:");
        String model = sc.nextLine();
        System.out.print("Year:");
        int year = sc.nextInt();
        sc.nextLine();
        sc.close();

        Car searchedCar = new Car(registrationPlate, brand, model, year);

        CarService carService = new CarService(CARS);
        Car car = carService.findCar(searchedCar);
        System.out.println(car);
    }
}
