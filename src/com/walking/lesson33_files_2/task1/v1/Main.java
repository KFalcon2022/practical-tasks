package com.walking.lesson33_files_2.task1.v1;

import com.walking.lesson33_files_2.model.Car;

import java.io.FileWriter;
import java.io.IOException;

//FileWriter

public class Main {
    private final static String CATALOG_PATH = "./resource/files/lesson32/carCatalog_33_lesson.txt";

    public static void main(String[] args) {
        Car[] cars = initCars();
        writeCatalog(cars);
    }

    private static void writeCatalog(Car[] cars) {
        try (FileWriter fw = new FileWriter(CATALOG_PATH)) {
            for (Car car : cars) {
                fw.write(writeFormat(car));
                fw.write('\n');
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
