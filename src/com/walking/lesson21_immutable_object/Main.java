package com.walking.lesson21_immutable_object;


import com.walking.lesson21_immutable_object.model.Car;

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

        findCar(searchedCar);
    }

    private static void findCar(Car searchedCar) {
        int numSearchedCar = 0;
        for (Car car : CARS) {
            if (car.equals(searchedCar)) {
                System.out.printf("Searched car's hash: %d%n", searchedCar.hashCode());
                System.out.printf("Car's hash: %d%n", car.hashCode());
                System.out.printf("Found car: %s%n", car);
                numSearchedCar++;
            }
        }

        if (numSearchedCar > 0) {
            System.out.printf("Searched %d cars%n", numSearchedCar);
        } else {
            System.out.println("Searched nothing");
        }
    }
}
