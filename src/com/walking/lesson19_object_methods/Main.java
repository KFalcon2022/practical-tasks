package com.walking.lesson19_object_methods;

import com.walking.lesson19_object_methods.model.Car;
import com.walking.lesson19_object_methods.services.CarService;

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
        System.out.println("lesson19_object_methods");

        Scanner in = new Scanner(System.in);
        System.out.println("enter govNumber:");
        String govNumber = in.nextLine();
        System.out.println("enter mark:");
        String mark = in.nextLine();
        System.out.println("enter color:");
        String color = in.nextLine();
        in.close();

        CarService cs = new CarService();
        System.out.println(cs.checkCar(govNumber, mark, color));
        System.out.println(cs.checkCar(new Car(govNumber, color, mark)));

    }
}
