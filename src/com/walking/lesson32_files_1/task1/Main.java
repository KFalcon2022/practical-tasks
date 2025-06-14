package com.walking.lesson32_files_1.task1;

import com.walking.lesson19_object_methods.car.Car;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Используя класс Car (или создав новый класс для сущности «машина», на ваше усмотрение) из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods/model">...</a>
 * Реализуйте сохранение массива машин в файл carCatalog.txt
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Car[] cars = new Car[6];
        cars[0] = new Car("Audi", "Печкин Ф.Б.", "уе777к");
        cars[1] = new Car("BMW", "Борисов Ю.А.", "ос025р");
        cars[2] = new Car("Ford", "Снегирь Ю.В.", "мр666м");
        cars[3] = new Car("Bentley", "Белова Д.М.", "ра345з");
        cars[4] = new Car("Ferrari", "Сергеев К.Л.", "уе999з");
        cars[5] = new Car("Москвич", "Попов А.Д.", "ар832с");

        saveCars(cars);
    }

    public static void saveCars(Car[] cars) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("./resources/carCatalog.txt")) {
            for (Car car : cars) {
                String information = car.toString() + "\n";
                byte[] buffer = information.getBytes();
                fos.write(buffer, 0, buffer.length);
            }
            System.out.println("Файл записан.");

        } catch (IOException ex) {
            System.out.println("Какая-то ошибка.");
        }
    }
}
