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
        Car[] cars = new Car[]{
                new Car("11", "to", "1", 2000, "black"),
                new Car("11", "to", "1", 2000, "black"),
                new Car("33", "to", "3", 2002, "black"),
                new Car("44", "to", "4", 2003, "black"),
                new Car("44", "to", "5", 2000, "white"),
                new Car("44", "to", "5", 2000, "red"),
                new Car("44", "to", "5", 2000, "orange"),
        };
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
        System.out.print("Color:");
        String color = sc.nextLine();
        sc.close();

        Car searchedCar = new Car(registrationPlate, brand, model, year, color);

        int numSearchedCar = 0;
        for (Car car : cars) {
            if (searchedCar.equals(car)) {
                System.out.println("Searched car's hash: " + searchedCar.hashCode());
                System.out.println("Car's hash: " + car.hashCode());
                System.out.println("Found car:" + car);
                numSearchedCar++;
            }
        }

        if (numSearchedCar > 0) {
            System.out.println("Searched " + numSearchedCar + " cars");
        } else {
            System.out.println("Searched nothing");
        }

    }
}
