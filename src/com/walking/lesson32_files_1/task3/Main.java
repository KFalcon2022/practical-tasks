package com.walking.lesson32_files_1.task3;

import com.walking.lesson32_files_1.task1.service.CarService;
import com.walking.lesson32_files_1.task1.models.Car;
import com.walking.lesson32_files_1.task1.service.RandomData;

import java.io.IOException;

/**
 * Реализуйте возможность добавления, удаления и изменения информации о машинах,
 * используя Задачи 1 и 2.
 * Работу с файлом предлагаю вынести в класс CarRepository,
 * но вы можете сделать иную реализацию на свое усмотрение.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        CarService carService = new CarService();
        Car carToDelete = new Car("VW","Passat",RandomData.randomVin(),"F111TF55");
        carService.addToFile(carToDelete);

        System.out.println("Original file:");
        carService.displayCars();

        carService.deleteCar(carToDelete);

        System.out.println("\nFile after first delete:");
        carService.displayCars();

        carService.deleteCar("ZFA3109101077105101023");
        System.out.println("\nFile after second delete:");
        carService.displayCars();

        carService.changeCarData(3,1,"KIA");
        System.out.println("\nFile after change:");
        carService.displayCars();
    }
}
