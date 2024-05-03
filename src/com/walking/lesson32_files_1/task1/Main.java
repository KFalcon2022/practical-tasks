package com.walking.lesson32_files_1.task1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Используя класс Car (или создав новый класс для сущности «машина», на ваше усмотрение) из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods/model">...</a>
 * Реализуйте сохранение массива машин в файл carCatalog.txt
 */
public class Main {
    public static void main(String[] args) throws IOException {

        try (FileOutputStream fos = new FileOutputStream("./resource/carCatalog.txt")) {

            byte[] buffer = Arrays.toString(initCars()).getBytes();
            fos.write(buffer);
            System.out.println("The file has been written!");

        } catch (IOException exception) {

            System.out.println(exception.getMessage());
        }
    }

    private static Car[] initCars() {

        Car car1 = new Car("BMW", "E90", "1234", 2007);
        Car car2 = new Car("Toyota", "Corolla", "1234", 1998);
        Car car3 = new Car("Toyota", "Camry", "0890", 2011);

        return new Car[]{car1, car2, car3};
    }
}

