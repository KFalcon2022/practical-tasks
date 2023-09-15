package com.walking.lesson19_object_methods;

import com.walking.lesson19_object_methods.model.Car;

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

        Car[] cars = new Car[5];

        for (int i = 0; i < 5; i++) {
            cars[i] = new Car();
        }

        for (Car car : cars) {
            System.out.println(car);
        }

        String mark = null;
        String color = null;
        int yearOfManufacture = 0;
        int stateNumber = 0;

        System.out.println("Введите данные машины:");
        System.out.println("Марка:");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            mark = scanner.nextLine();
        }
        System.out.println("Цвет:");
        if (scanner.hasNextLine()) {
            color = scanner.nextLine();
        }
        System.out.println("Номер:");
        if (scanner.hasNextInt()) {
            stateNumber = scanner.nextInt();
        }
        System.out.println("Год выпуска:");
        if (scanner.hasNextInt()) {
            yearOfManufacture = scanner.nextInt();
        }

        scanner.close();
        System.out.println("************************");

        Car searchingCar = new Car(mark, yearOfManufacture, color, stateNumber);

        System.out.println(searchCar(searchingCar, cars));
    }

    private static String searchCar(Car searchingCar, Car[] cars) {

        for (Car car : cars) {
            if (car.equals(searchingCar)) {
                return "Искомая машина: " + searchingCar.toString();
            }
        }
        return "Совпадений не найдено.";
    }
}
