package com.walking.lesson32_files_1.task1;

import com.walking.lesson32_files_1.task1.model.Car;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Используя класс Car (или создав новый класс для сущности «машина», на ваше усмотрение) из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods/model">...</a>
 * Реализуйте сохранение массива машин в файл carCatalog.txt
 */
public class Main {
    final static String PATH = "./resource/carCatalog.txt";
    public static void main(String[] args) {
        Car[] cars = new Car[]{new Car("P079BK92", "Toyota", "Camry", 2017, "1234567891234567"),
                new Car("A567EY45", "BMW", "X5", 2019, "9876543219876543"),
                new Car("M891OP77", "Ford", "Focus", 2020, "4567891234567891"),
                new Car("E456ВO63", "Mercedes-Benz", "E-Class", 2018, "7891234567891234"),
                new Car("K789MH51", "Honda", "Civic", 2016, "6543219876543219")};

        try (FileOutputStream out = new FileOutputStream(PATH)){
            for (Car car : cars) {
                String outString = new String("%s|%s|%s|%d|%s"
                        .formatted(car.getRegistrationNumber(), car.getBrand(),car.getModel(),car.getYearCar(),car.getVin()) +"\n");

                out.write(outString.getBytes());
            }
        }
        catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
