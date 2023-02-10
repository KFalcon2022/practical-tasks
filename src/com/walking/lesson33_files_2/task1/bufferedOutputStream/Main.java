package com.walking.lesson33_files_2.task1.bufferedOutputStream;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        Car[] cars = new Car[] {
                new Car("Mazda", "e857kx", 2003, "white", true),
                new Car("BMW", "k123kk", 2017, "black", true),
                new Car("Mercedes", "c777cc", 2022, "red", true),
                new Car("Lada", "m693pa", 1997, "yellow", false)
        };

        File carCatalogPath = new File("./resource/carCatalog.txt");

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(carCatalogPath))) {
            for (Car car : cars) {
                byte[] buffer = car.prepareCarToWriteToFile().getBytes();

                bos.write(buffer);
                bos.write('\n');
                bos.flush();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
