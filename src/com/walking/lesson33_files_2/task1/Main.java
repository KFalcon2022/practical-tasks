package com.walking.lesson33_files_2.task1;

import com.walking.lesson33_files_2.task1.model.Car;
import com.walking.lesson33_files_2.task1.model.CarColor;
import com.walking.lesson33_files_2.task1.model.IOStreamType;
import com.walking.lesson33_files_2.task1.service.CarRepository;

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
        Car[] testCars = createCars();
        Car[] loadedCars;
        File carCatalog = new File("./practical-tasks/resource/lesson32/carCatalog.txt");
        CarRepository carRepository = new CarRepository(carCatalog);

        System.out.println("Машины перед загрузкой из файлы: ");
        displayCars(testCars);

        carRepository.save(testCars, IOStreamType.FILE_WRITER);
        loadedCars = carRepository.load(IOStreamType.FILE_READER);
        System.out.println("Машины после сохранения и загрузки через FileWriter\\Reader: ");
        displayCars(loadedCars);

        carRepository.save(testCars, IOStreamType.BUFFERED_OUTPUT_STREAM);
        loadedCars = carRepository.load(IOStreamType.BUFFERED_INPUT_STREAM);
        System.out.println("Машины после сохранения и загрузки через BufferedOutput\\InputStream: ");
        displayCars(loadedCars);

        carRepository.save(testCars, IOStreamType.BUFFERED_WRITER);
        loadedCars = carRepository.load(IOStreamType.BUFFERED_READER);
        System.out.println("Машины после сохранения и загрузки через BufferedWriter\\Reader: ");
        displayCars(loadedCars);
    }

    public static Car[] createCars() {
        return new Car[]{new Car("A123BC", 2024, CarColor.RED, false),
                         new Car("Z000ZZ", 2000, CarColor.YELLOW, true),
                         new Car("F999FF", 1970, CarColor.BLACK, true)};
    }

    public static void displayCars(Car[] cars) {
        System.out.println("-".repeat(56));

        for (Car car : cars) {
            System.out.println(car);
        }

        System.out.println();
    }
}
