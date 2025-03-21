package com.walking.lesson19_object_methods;

import com.walking.lesson19_object_methods.autos.Auto;

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

        Auto[] autos = new Auto[6];
        autos[0] = new Auto("Audi", "Печкин Ф.Б.", "уе777к");
        autos[1] = new Auto("BMW", "Борисов Ю.А.", "ос025р");
        autos[2] = new Auto("Ford", "Снегирь Ю.В.", "мр666м");
        autos[3] = new Auto("Bentley", "Белова Д.М.", "ра345з");
        autos[4] = new Auto("Ferrari", "Сергеев К.Л.", "уе999з");
        autos[5] = new Auto("Москвич", "Попов А.Д.", "ар832с");

        Scanner in = new Scanner(System.in);
        System.out.print("Марка машины: ");
        String make = in.nextLine();
        System.out.print("ФИО владельца: ");
        String owner = in.nextLine();
        System.out.print("Номер машины: ");
        String number = in.nextLine();

        Auto car = new Auto(make, owner, number);

        if (!car.findAuto(autos)) {
            System.out.println("Машина не найдена!");
        } else {
            System.out.println(car);
            System.out.println(car.hashCode());
        }
    }
}
