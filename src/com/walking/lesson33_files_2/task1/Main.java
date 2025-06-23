package com.walking.lesson33_files_2.task1;

import com.walking.lesson33_files_2.task1.model.Car;
import com.walking.lesson33_files_2.task1.model.Color;
import com.walking.lesson33_files_2.task1.repository.CarRepository;
import com.walking.lesson33_files_2.task1.service.CarService;

import java.util.Arrays;

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
        CarRepository carRepository = new CarRepository();
        CarService carService = new CarService(carRepository);

        System.out.println("Машины в репозитории после инициализации сервиса:");
        printCars(carService.getCars());

        //добавление
        carService.add(new Car("A123BC", 2024, Color.RED, false));
        carService.add(new Car("Z000ZZ", 2000, Color.YELLOW, true));
        carService.add(new Car("F999FF", 1970, Color.BLACK, true));

        System.out.println("Машины после добавления:");
        printCars(carService.getCars());

        //удаление
        carService.remove(new Car("A123BC", 2024, Color.RED, false));

        System.out.println("Машины после удаления:");
        printCars(carService.getCars());

        //изменение информации
        Car sampleCar = new Car("Z000ZZ", 2000, Color.YELLOW, true);
        Car foundCar = carService.find(sampleCar);

        if (foundCar != null) {
            foundCar.setColor(Color.INDIGO);
            foundCar.setFine(false);

            carService.add(foundCar);
        }

        System.out.println("Машины после изменения:");
        printCars(carService.getCars());
    }

    public static void printCars(Car[] cars) {
        System.out.println("-".repeat(56));

        for (Car car : cars) {
            System.out.println(car);
        }

        System.out.println();
    }
}
