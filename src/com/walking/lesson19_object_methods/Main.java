package com.walking.lesson19_object_methods;

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

        Car[] cars = new Car[]{
                new Car("MAZDA", "CX5", "RED", "X555CX95"),
                new Car("VOLVO", "CX70", "BLACK", "T222TT77"),
                new Car("NISSAN", "X-TRAIL", "GREY", "P420AK29"),
                new Car("CHEVROLET", "NIVA", "GREY", "H123AA51")};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter car parameters for the database search:");
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("License plate: ");
        String licensePlate = scanner.nextLine();

        scanner.close();

        Car foundCar = new Car(brand, model, color, licensePlate);

        findCar(foundCar, cars);
    }

    static void findCar(Car foundCar, Car[] cars) {
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

