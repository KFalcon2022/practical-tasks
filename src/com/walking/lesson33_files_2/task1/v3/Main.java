package com.walking.lesson33_files_2.task1.v3;

import com.walking.lesson33_files_2.model.Car;

import java.io.*;

//BufferedWriter
public class Main {
    private final static String CATALOG_PATH = "./resource/files/lesson32/carCatalog_33_lesson.txt";

    public static void main(String[] args) {
        Car[] cars = initCars();
        File carCatalog = new File(CATALOG_PATH);
        writeCatalog(cars, carCatalog);
    }

    private static void writeCatalog(Car[] cars, File carCatalog) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(carCatalog))) {
            for (Car car : cars) {
                bw.write(writeFormat(car));
                bw.write('\n');
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
