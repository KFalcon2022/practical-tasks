package com.walking.lesson32_files_1.task1;

import com.walking.lesson32_files_1.task1.model.Car;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Используя класс Car (или создав новый класс для сущности «машина», на ваше усмотрение) из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods/model">...</a>
 * Реализуйте сохранение массива машин в файл carCatalog.txt
 */
public class Main {
    private final static String CATALOG_PATH = "./resource/files/lesson32/carCatalog.txt";

    public static void main(String[] args) {
        Car[] cars = initCars();
        writeCatalog(cars);

    }

    private static void writeCatalog(Car[] cars) {
        try (FileOutputStream fos = new FileOutputStream(CATALOG_PATH, true)) {

            for (Car car : cars) {
                fos.write(writeFormat(car).getBytes());
                fos.write('\n');
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String writeFormat(Car car) {
        return "%s;%s;%d;%d".formatted(car.getMark(), car.getColor(), car.getYearManufacture(), car.getStateNumber());
    }

    private static Car[] initCars() {
        return new Car[] {
                new Car("Audi", "Черный", 2001, 674921),
                new Car("BMW", "Синий", 2002, 674922),
                new Car("Renault", "Зеленый", 2003, 674923),
                new Car("Lada", "Крвсный", 2004, 674924),
                new Car("Volvo", "Серый", 2005, 674925),
                new Car("Ria", "Белый", 2006, 674926),
                new Car("Mazda", "Желтый", 2007, 674927),
                new Car("Suzuki", "Крвсный", 2008, 674928),
                new Car("Lada", "Синий", 2009, 674929),
        };
    }
}
