package com.walking.lesson33_files_2.task2;

import com.walking.lesson32_files_1.task1.model.Car;

import java.io.*;

/**
 * Реализуйте Задачу 2 из урока
 * <a href="https://telegra.ph/Rabota-s-fajlami-CHast-I-12-17">...</a>
 * с помощью:
 * <p>
 * Вариант 1: FileReader;
 * Вариант 2: BufferedInputStream;
 * Вариант 3: BufferedReader.
 */
public class Main {
    static File file = new File("./resource/carCatalog.txt");

    public static void main(String[] args) {
        Car[] cars = bufferdInputStreamCars();

        for(Car car:cars) {
            System.out.println(car);
        }
    }

    public static Car[] fileRead () {
        try (FileReader fileReader = new FileReader(file)){

            StringBuilder stringBuilder = new StringBuilder();
            int c;

            while ((c = fileReader.read())!=-1) {
                stringBuilder.append( (char) c);
            }

            String stringCarCatalog = new String(stringBuilder);
            String[] stringArrayCarCatalog = stringCarCatalog.split("\n");

            Car[] cars = new Car[stringArrayCarCatalog.length];
            int i = 0;

            for (String stringCar : stringArrayCarCatalog) {
                cars[i++] = new Car(stringCar.split("\\|"));
            }

            return cars;

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static Car [] bufferdInputStreamCars() {
        try(FileInputStream in = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(in)) {

            StringBuilder stringBuilder = new StringBuilder();
            int c;

            while ((c = bufferedInputStream.read())!=-1) {
                stringBuilder.append( (char) c);
            }

            String stringCarCatalog = new String(stringBuilder);
            String[] stringArrayCarCatalog = stringCarCatalog.split("\n");

            Car[] cars = new Car[stringArrayCarCatalog.length];
            int i = 0;

            for (String stringCar : stringArrayCarCatalog) {
                cars[i++] = new Car(stringCar.split("\\|"));
            }

            return cars;
        }
        catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

        return null;
    }

    public static Car[] bufferedReader () {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            StringBuilder stringBuilder = new StringBuilder();
            int c;

            while ((c = bufferedReader.read())!=-1) {
                stringBuilder.append( (char) c);
            }

            String stringCarCatalog = new String(stringBuilder);
            String[] stringArrayCarCatalog = stringCarCatalog.split("\n");

            Car[] cars = new Car[stringArrayCarCatalog.length];
            int i = 0;

            for (String stringCar : stringArrayCarCatalog) {
                cars[i++] = new Car(stringCar.split("\\|"));
            }

            return cars;
        }
        catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

        return null;
    }
}
