package com.walking.lesson32_files_1.task1;

import com.walking.lesson32_files_1.task1.model.Car;
import java.io.*;

/**
 * Используя класс Car (или создав новый класс для сущности «машина», на ваше усмотрение) из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods/model">...</a>
 * Реализуйте сохранение массива машин в файл carCatalog.txt
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Car[] cars = initCars();
        System.out.println(cars[0]);
        StringBuilder text = new StringBuilder();

        for (int i = 0; i<cars.length; i++){
            text.append(cars[i]).append("\n");
        }

        try (FileOutputStream fos = new FileOutputStream("./resources/carCatalog.txt"))
        {
            byte[] buffer = text.toString().getBytes();

            fos.write(buffer, 0, buffer.length);
            System.out.println("The file has been written");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Car[] initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "yellow", true);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true);
        Car car6 = new Car("RR-666-RR", 2018, "yellow", true);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true);
        Car car10 = new Car("RR-000-RR", 2018, "yellow", true);

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
