package com.walking.lesson19_object_methods;

import com.walking.lesson19_object_methods.autos.Car;

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

        Car[] cars = new Car[6];
        cars[0] = new Car("Audi", "Печкин Ф.Б.", "уе777к");
        cars[1] = new Car("BMW", "Борисов Ю.А.", "ос025р");
        cars[2] = new Car("Ford", "Снегирь Ю.В.", "мр666м");
        cars[3] = new Car("Bentley", "Белова Д.М.", "ра345з");
        cars[4] = new Car("Ferrari", "Сергеев К.Л.", "уе999з");
        cars[5] = new Car("Москвич", "Попов А.Д.", "ар832с");

        Scanner in = new Scanner(System.in);
        System.out.print("Марка машины: ");
        String make = in.nextLine();
        System.out.print("ФИО владельца: ");
        String owner = in.nextLine();
        System.out.print("Номер машины: ");
        String number = in.nextLine();

        Car car = new Car(make, owner, number);

        if (!carExist(cars, car)) {
            System.out.println("Машина не найдена!");
        } else {
            System.out.println(car);
            System.out.println(car.hashCode());
        }
    }

    public static boolean carExist(Car[] cars, Car car) {
        for (Car car1 : cars) {
            if (car1.equals(car)) {
                return true;
            }
        }
        return false;
    }
}
