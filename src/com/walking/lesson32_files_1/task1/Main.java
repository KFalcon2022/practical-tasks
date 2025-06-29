package com.walking.lesson32_files_1.task1;

import com.walking.lesson32_files_1.task1.model.Car;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Используя класс Car (или создав новый класс для сущности «машина», на ваше усмотрение) из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods/model">...</a>
 * Реализуйте сохранение массива машин в файл carCatalog.txt
 */
public class Main {

    public static final String CAR_CATALOG_TXT_DIRECTORY = "./resource/files/lesson32/task1/carCatalog.txt";

    public static void main(String[] args) {
        Car[] cars = initCars();

        try (FileOutputStream carCatalog = new FileOutputStream(CAR_CATALOG_TXT_DIRECTORY, false)) {
            for (Car car : cars) {
                String carsInformation = carInformationToFileView(car);

                byte[] bytesCarInformation = carsInformation.getBytes();

                carCatalog.write(bytesCarInformation);
                carCatalog.write("\n".getBytes());
            }

            System.out.println("Record is over");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Car[] initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow");
        Car car2 = new Car("RR-222-RR", 2016, "yellow");
        Car car4 = new Car("RR-444-RR", 2018, "yellow");
        Car car5 = new Car("RR-555-RR", 2018, "yellow");
        Car car6 = new Car("RR-666-RR", 2018, "yellow");
        Car car7 = new Car("RR-777-RR", 2018, "yellow");
        Car car3 = new Car("RR-333-RR", 2017, "yellow");
        Car car8 = new Car("RR-888-RR", 2018, "yellow");
        Car car9 = new Car("RR-999-RR", 2018, "yellow");
        Car car10 = new Car("RR-000-RR", 2018, "yellow");

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }

    private static String carInformationToFileView(Car car) {
        return "%s;%s;%s".formatted(car.getNumber(), car.getYear(), car.getColor());
    }
}
