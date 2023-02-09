package com.walking.lesson32_files_1.task3;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Car mazda = new Car("Mazda", "e857kx", 2003, "white", true);
        Car bmw = new Car("BMW", "k123kk", 2017, "black", false);
        Car mercedes = new Car("Mercedes", "c777cc", 2022, "red", true);
        Car lada = new Car("Lada", "m693pa", 1997, "yellow", false);

        Car[] cars = new Car[] {mazda, bmw, mercedes, lada};

        File carCatalogPath = new File("./resource/carCatalog.txt");

        CarRepository carRepository = new CarRepository(carCatalogPath);

        carRepository.writeToFile(cars);

        Car[] newCars = carRepository.createCarArray();

        for (Car car : newCars) {
            System.out.println(car);
        }

        Car audi = new Car("Audi", "y543ce", 2015, "black", true);

        carRepository.addCarToFile(audi);

        carRepository.deleteCarFromFile(bmw);

        carRepository.changeCarData(mazda, "blue", false);
    }
}