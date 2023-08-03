package com.walking.lesson33_files_2.task1;

import com.walking.lesson32_files_1.task1.model.Car;

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
    static File file = new File("./resource/carCatalog.txt");
    public static void main(String[] args) {
        Car[] cars = new Car[]{new Car("P079BK92", "Toyota", "Camry", 2017, "1234567891234567"),
                new Car("A567EY45", "BMW", "X5", 2019, "9876543219876543"),
                new Car("M891OP77", "Ford", "Focus", 2020, "4567891234567891"),
                new Car("E456ВO63", "Mercedes-Benz", "E-Class", 2018, "7891234567891234"),
                new Car("K789MH51", "Honda", "Civic", 2016, "6543219876543219"),
                new Car("K789MH51", "Honda", "Civic", 2016, "6543219876543219"),
                new Car("K789MH51", "Honda", "Civic", 2016, "6543219876543219")};

        //fileWrite(cars);

        bufferedOutputWrite(cars);

        //bufferedWrite(cars);


    }

    public static void fileWrite(Car[] cars) {
        try(FileWriter fw = new FileWriter(file)) {
            for(Car car : cars) {

                String outString = new String("%s|%s|%s|%d|%s"
                        .formatted(car.getRegistrationNumber(), car.getBrand(),car.getModel(),car.getYearCar(),car.getVin()) +"\n");

                fw.write(outString);
            }
        }
        catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public static void bufferedOutputWrite (Car [] cars) {
        try (FileOutputStream out = new FileOutputStream(file); BufferedOutputStream bos = new BufferedOutputStream(out)){

            for (Car car : cars) {
                String outString = new String("%s|%s|%s|%d|%s"
                        .formatted(car.getRegistrationNumber(), car.getBrand(),car.getModel(),car.getYearCar(),car.getVin()) +"\n");
                bos.write(outString.getBytes());

            }

        }
        catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    public static void bufferedWrite (Car [] cars) {
        try (BufferedWriter outputStream = new BufferedWriter(new FileWriter(file))){
            for (Car car:cars) {
                String outString = new String("%s|%s|%s|%d|%s"
                        .formatted(car.getRegistrationNumber(), car.getBrand(),car.getModel(),car.getYearCar(),car.getVin()) +"\n");
                outputStream.write(outString);
            }

        }
        catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

}
