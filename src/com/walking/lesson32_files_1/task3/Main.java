package com.walking.lesson32_files_1.task3;

import com.walking.lesson32_files_1.task3.model.Car;
import java.util.Arrays;

/**
 * Реализуйте возможность добавления, удаления и изменения информации о машинах,
 * используя Задачи 1 и 2.
 * Работу с файлом предлагаю вынести в класс CarRepository,
 * но вы можете сделать иную реализацию на свое усмотрение.
 */
public class Main {
    public static void main(String[] args) {
        Car[] cars = initCars();
        CarRepository carRepo = new CarRepository(cars);

        carRepo.exportCarCatalogToFile("./resources/carCatalog.txt");
        carRepo.addCar(new Car("AAA-123-ZZZ", 2023, "white", true));
        carRepo.removeCar("RR-777-RR");
        carRepo.editCar("RR-556-RR", new Car("AB-123-YZ", 2013, "brown", true));
        carRepo.exportCarCatalogToFile("./resources/carCatalog.txt");
        System.out.println("______________________________________________________________________");

        Car[] cars1 = carRepo.importCarCatalogFromFile("./resources/carCatalog.txt");
        System.out.println(Arrays.toString(cars1));
    }

    private static Car[] initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "purple", true);
        Car car3 = new Car("RR-333-RR", 2017, "grey", true);
        Car car4 = new Car("RR-444-RR", 2018, "white", true);
        Car car5 = new Car("RR-555-RR", 2010, "green", false);
        Car car6 = new Car("RR-666-RR", 2020, "black", true);
        Car car7 = new Car("RR-777-RR", 2007, "yellow", true);
        Car car8 = new Car("RR-888-RR", 1993, "brown", false);
        Car car9 = new Car("RR-999-RR", 1999, "red", true);
        Car car10 = new Car("RR-000-RR", 2022, "blue", true);

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }

}
