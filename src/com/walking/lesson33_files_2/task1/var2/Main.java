package com.walking.lesson33_files_2.task1.var2;

import com.walking.lesson19_object_methods.car.Car;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * для второго варианта в таск2 и здесь сделала отдельный файл на англе,
 * не уверена, можно ли через FileInputStream кириллицу читать
 * (у меня не выходит)
 */
public class Main {
    public static final String FILE_LOCATION = "./resources/carCatalog1.txt";

    public static void main(String[] args) throws IOException {
        Car[] cars = new Car[5];
        cars[0] = new Car("Audi", "Styles H.", "rt777e");
        cars[1] = new Car("BMW", "Steeve J.", "er025w");
        cars[2] = new Car("Ford", "Potter H.", "we666a");
        cars[3] = new Car("Bentley", "Malfoy D.", "po345r");
        cars[4] = new Car("Ferrari", "Hadid G..", "re999t");

        saveCars(cars);
    }

    public static void saveCars(Car[] cars) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(FILE_LOCATION);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            for (Car car : cars) {
                String carInfo = car.getBrand() + ", " + car.getOwner() + ", " + car.getNumber() + "\n";
                byte[] buffer = carInfo.getBytes();
                bos.write(buffer, 0, buffer.length);
            }
            System.out.println("Файл записан.");

        } catch (IOException ex) {
            throw new RuntimeException("Не удалось записать файл", ex);
        }
    }
}
