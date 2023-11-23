package com.walking.lesson33_files_2.task1;

import com.walking.lesson33_files_2.task1.models.Car;
import com.walking.lesson33_files_2.task1.service.RandomData;
import com.walking.lesson33_files_2.task1.service.CarService;

import java.io.IOException;

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
    public static void main(String[] args) throws IOException {
        Car[] cars = new Car[4];
        cars[0]= new Car("Tesla","X", RandomData.randomVin(),"X117EN799");
        cars[1]= new Car("Rollce Royce","Phantom",RandomData.randomVin(),"H726KT799");
        cars[2]= new Car("Hyndai","Santa Fe",RandomData.randomVin(),"C111KK77");
        cars[3]= new Car("Tesla","X",RandomData.randomVin(),"X117EN799");
        CarService carService = new CarService();
        carService.addToFile(cars);
        carService.addToFile(new Car("Xla","11ILA",RandomData.randomVin(),"A111AO77"));
        carService.displayCars();

    }
}
