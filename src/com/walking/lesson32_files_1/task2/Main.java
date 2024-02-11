package com.walking.lesson32_files_1.task2;

import com.walking.lesson32_files_1.task1.models.Car;
import com.walking.lesson32_files_1.task1.service.CarService;

import java.io.IOException;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        CarService carServiceRead = new CarService();
        String carString = carServiceRead.readCarCatalog();
        Car[] carsGarage=carServiceRead.parseCar(carString);
       for (Car car : carsGarage){
           System.out.println(car.displayCar());
       }
    }
}
