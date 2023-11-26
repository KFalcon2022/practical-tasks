package com.walking.lesson33_files_2.task1;

import com.walking.lesson19_object_methods.model.Car;

import java.io.*;

/**
 * Реализуйте Задачу 1 из урока
 * <a href="https://telegra.ph/Rabota-s-fajlami-CHast-I-12-17">...</a>
 * с помощью:
 * <p>
 * Вариант 1: FileWriter;
 * Вариант 2: BufferedOutputStream;
 * Вариант 3: BufferedWriter.
 */
public class Main {
    public static void main(String[] args) {

        Car[] cars = {
                new Car("ZFA25648900556937", "Ferrari", "petrol", "person1"),
                new Car("ZFA22356404865217", "Bugatti", "electric", "person2"),
                new Car("ZFA44523895557832", "Land Rover", "petrol", "person3"),
                new Car("ZFA21235685446546", "Cadillac", "petrol", "person4")
        };

        File carCatalog = new File("./", "carCatalog.txt");

//        FileWriter
        try (FileWriter fileWriter = new FileWriter(carCatalog)) {

            if (!carCatalog.exists()) {
                carCatalog.createNewFile();
            }
            for (Car car : cars) {
                fileWriter.write(car + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

//        BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(carCatalog))) {
            for (Car car : cars) {
                byte[] bytes = car.toString().getBytes();
                bufferedOutputStream.write(bytes, 0, bytes.length);
                bufferedOutputStream.write('\n');
                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

//        BufferedWriter
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(carCatalog))) {
            for (Car car : cars) {
                bf.write(car + "\n");
                bf.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
