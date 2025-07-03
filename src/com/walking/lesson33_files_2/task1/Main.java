package com.walking.lesson33_files_2.task1;

import com.walking.lesson19_object_methods.car.Car;

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
    public static final String FILE_LOCATION = "./resources/carCatalog3.txt";

    public static void main(String[] args) throws IOException {
        Car[] cars = new Car[6];
        cars[0] = new Car("Audi", "Печкин Ф.Б.", "уе777к");
        cars[1] = new Car("BMW", "Борисов Ю.А.", "ос025р");
        cars[2] = new Car("Ford", "Снегирь Ю.В.", "мр666м");
        cars[3] = new Car("Bentley", "Белова Д.М.", "ра345з");
        cars[4] = new Car("Ferrari", "Сергеев К.Л.", "уе999з");
        cars[5] = new Car("Москвич", "Попов А.Д.", "ар832с");

        saveCars3(cars);
    }

    public static void saveCars1(Car[] cars) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_LOCATION)) {
            for (Car car : cars) {
                String carInfo = car.toString();
                writer.write(carInfo);
                writer.append('\n');
                writer.flush();
            }
            System.out.println("Файл записан.");

        } catch (IOException ex) {
            throw new RuntimeException("Не удалось записать файл", ex);
        }
    }

    public static void saveCars2(Car[] cars) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(FILE_LOCATION);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            for (Car car : cars) {
                String carInfo = car.toString() + "\n";
                byte[] buffer = carInfo.getBytes();
                bos.write(buffer, 0, buffer.length);
            }
            System.out.println("Файл записан.");

        } catch (IOException ex) {
            throw new RuntimeException("Не удалось записать файл", ex);
        }
    }

    public static void saveCars3(Car[] cars) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_LOCATION);
             BufferedWriter bw = new BufferedWriter(writer)) {
            for (Car car : cars) {
                String carInfo = car.toString();
                bw.write(carInfo + "\n");
            }
            System.out.println("Файл записан.");

        } catch (IOException ex) {
            throw new RuntimeException("Не удалось записать файл", ex);
        }
    }
}
