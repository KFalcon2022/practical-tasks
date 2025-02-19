package com.walking.lesson19_object_methods;

import com.walking.lesson19_object_methods.model.Car;
import com.walking.lesson19_object_methods.model.CarService;

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
        Car[] cars = {new Car(2000, "a123aa77", "green", "bmw"),
                      new Car(2001, "b222bb77", "black", "mercedes"),
                      new Car(2005, "c111cc777", "white", "audi"),
                      new Car(2020, "e555ee55", "red", "skoda")
                     };

        CarService dataBase = new CarService(cars);

        Scanner io = new Scanner(System.in);
        System.out.println("Enter car's manufacture year");
        int year = io.nextInt();
        String tmp = io.nextLine(); //проблема пропуска строки Scanner'ом после nextInt

        System.out.println("Enter plate number");
        String number = io.nextLine().toLowerCase();

        System.out.println("Enter color");
        String color = io.nextLine().toLowerCase();

        System.out.println("Enter model");
        String model = io.nextLine().toLowerCase();

        io.close();

        Car userCar = new Car(year, number, color, model);
        Car foundCar = dataBase.searchCar(userCar);
        System.out.println("Found car: " + foundCar);
    }
}
