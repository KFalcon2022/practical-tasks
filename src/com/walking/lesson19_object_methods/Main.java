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
        String mark = null, color = null, stateNumber = null;
        int yearOfManufacture = 0;

        Car[] cars = new Car[20];

        for (int i = 0; i < 20; i++) {
            cars[i] = new Car();
        }

        for (Car car : cars) {
            System.out.println(car);
        }

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
        System.out.println("Год выпуска:");
        if (scanner.hasNextInt()) {
            yearOfManufacture = scanner.nextInt();
        }
        System.out.println("Номер:");
        if (scanner.hasNextLine()) {
            stateNumber = scanner.nextLine();
        }
        scanner.close();
        System.out.println("************************");

        System.out.println(searchCar(mark, color, yearOfManufacture, stateNumber, cars));
    }

    private static String searchCar(String mark, String color, int yearOfManufacture, String stateNumber, Car[] cars) {
        Car newCar = new Car(mark, yearOfManufacture, color,  stateNumber);

        for (Car car : cars) {
            if (car.equals(newCar)) {
                return "Искомая машина: " + newCar.toString();
            }
        }
        return "Совпадений не найдено.";
    }
}
