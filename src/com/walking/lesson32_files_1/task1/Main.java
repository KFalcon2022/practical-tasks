package com.walking.lesson32_files_1.task1;

import com.walking.lesson32_files_1.task1.model.Car;
import com.walking.lesson32_files_1.task1.model.ColorType;
import com.walking.lesson32_files_1.task1.model.MarkType;

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
                fos.write(car.toString().getBytes());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Car[] initCars() {
        return new Car[] {
                new Car(MarkType.AUDI, ColorType.BLACK, 2001, 674921),
                new Car(MarkType.BMW, ColorType.BLUE, 2002, 674922),
                new Car(MarkType.RENAULT, ColorType.GREEN, 2003, 674923),
                new Car(MarkType.LADA, ColorType.RED, 2004, 674924),
                new Car(MarkType.VOLVO, ColorType.GREY, 2005, 674925),
                new Car(MarkType.KIA, ColorType.WHITE, 2006, 674926),
                new Car(MarkType.MAZDA, ColorType.YELOW, 2007, 674927),
                new Car(MarkType.SUZUKI, ColorType.RED, 2008, 674928),
                new Car(MarkType.LADA, ColorType.BLUE, 2009, 674929),
        };
    }
}
