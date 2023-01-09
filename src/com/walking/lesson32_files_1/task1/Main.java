package com.walking.lesson32_files_1.task1;

import com.walking.lesson19_object_methods.model.Car;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Используя класс Car (или создав новый класс для сущности «машина», на ваше усмотрение) из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods/model">...</a>
 * Реализуйте сохранение массива машин в файл carCatalog.txt
 */
public class Main {
    public static void main(String[] args) {
        Car[] cars = {
                new Car("ZFA25648900556937", "Ferrari", "petrol", "person1"),
                new Car("ZFA22356404865217", "Bugatti", "electric", "person2"),
                new Car("ZFA44523895557832", "Land Rover", "petrol", "person3"),
                new Car("ZFA21235685446546", "Cadillac", "petrol", "person4")
        };

        try(FileOutputStream outputStream = new FileOutputStream("./carCatalog.txt")) {
            for (Car car:cars) {
                byte[] bytes = car.toString().getBytes();
                outputStream.write(bytes, 0, bytes.length);
                outputStream.write('\n');
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
