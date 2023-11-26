package com.walking.lesson33_files_2.task1;

import com.walking.lesson33_files_2.task1.model.Car;
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
    public static void main(String[] args) {
            Car[] cars = initCars();
            WriterCarsToFile writerCarsToFile = new WriterCarsToFile(cars);

        try {
            writerCarsToFile.writeToFileUsingFileWriter();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try {
            writerCarsToFile.writeToFileUsingBufferedOutputStream();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try {
            writerCarsToFile.writeToFileUsingBufferedWriter();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static Car[] initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "purple", true);
        Car car3 = new Car("RR-333-RR", 2017, "grey", true);
        Car car4 = new Car("RR-444-RR", 2018, "white", true);
        Car car5 = new Car("RR-555-RR", 2018, "green", true);
        Car car6 = new Car("RR-666-RR", 2018, "black", true);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car("RR-888-RR", 2018, "brown", true);
        Car car9 = new Car("RR-999-RR", 2018, "red", true);
        Car car10 = new Car("RR-000-RR", 2018, "blue", true);

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
