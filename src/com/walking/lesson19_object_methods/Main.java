package com.walking.lesson19_object_methods;

import com.walking.lesson19_object_methods.model.Car;

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
        Car[] cars = new Car[10];
        fillCarArray(cars);
        searchCarInDataBase(new Car("purple", "Nissan", "8888KA-3", "2GCEC19K9K1134990"), cars);
    }

    private static void fillCarArray(Car[] cars) {
        cars[0] = new Car("blue", "BMW", "8888KA-3", "2B3LA53H08H256544");
        cars[1] = new Car("purple", "Nissan", "8888KA-2", "2GCEC19K9K1134990");
        cars[2] = new Car("white", "Skoda", "1853KE-1", "2G1WH52K959272082");
        cars[3] = new Car("blue", "Lada", "8318GA-7", "WBAEU33404PR42781");
        cars[4] = new Car("white", "BMW", "8888KA-7", "5NPDH4AE5DH344346");
        cars[5] = new Car("black", "Dodge", "9718GD-7", "1G2ZG57B084162811");
        cars[6] = new Car("yellow", "Opel", "1288DS-4", "1FADP3F20DL202208");
        cars[7] = new Car("black", "Renault", "9238JH-5", "1N4AL21E78N545909");
        cars[8] = new Car("silver", "BMW", "5546KJ-7", "2A4RR8DG2BR707087");
        cars[9] = new Car("black", "Nissan", "8127SA-7", "1FAFP55SXYA259149");
    }

    private static void searchCarInDataBase(Car searchingCar, Car[] cars) {
        for (Car car : cars) {
            if (car.searchCar(searchingCar)) {
                System.out.println("Машина " + searchingCar.toString() + " найдена в базе!");
                return;
            }
        }
        System.out.println("Машины в базе нет!");
    }
}
