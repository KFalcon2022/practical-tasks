package com.walking.lesson33_files_2.task1.var1;

import com.walking.lesson33_files_2.task1.var1.model.Car;
import com.walking.lesson33_files_2.task1.var1.servise.CarRepository;
import com.walking.lesson33_files_2.task1.var1.servise.CarService;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
    public static final String CAR_CATALOG_FILE_PATH = "./resource/files/lesson33/task1/carCatalog.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(CAR_CATALOG_FILE_PATH);

        if (!file.exists() || !file.isFile() || !file.canWrite() || !file.createNewFile()) {
            throw new RuntimeException("File %s is not available".formatted(CAR_CATALOG_FILE_PATH));
        }

        Car[] cars = initCars();
        CarService carService = new CarService(cars);

        CarRepository carRepository = new CarRepository(file);
        carRepository.writeCar(cars);

        cars = carRepository.readCar();
        for (Car car: cars) {
            System.out.println(car);
        }
    }

    private static Car createCar() {
//        Неудачный шаг со сканером, повторно использовать метод createCar() мы не сможем.
//        Спишем на условности
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a car's number");
        String number = scanner.nextLine();

        System.out.println("Enter a car's color");
        String color = scanner.nextLine();

        System.out.println("Enter a car's year");
        int year = scanner.nextInt();

        System.out.println("Enter a actuality of technical inspection");
        boolean actualTechnicalInspection = scanner.nextBoolean();

        scanner.close();

        return new Car(number, year, color, actualTechnicalInspection);
    }

    private static Car[] initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "yellow", true);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true);
        Car car6 = new Car("RR-666-RR", 2018, "yellow", true);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true);
        Car car10 = new Car("RR-000-RR", 2018, "yellow", true);

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
