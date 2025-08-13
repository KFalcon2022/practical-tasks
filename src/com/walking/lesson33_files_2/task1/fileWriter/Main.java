package com.walking.lesson33_files_2.task1.fileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Car[] cars = new Car[] {
                new Car("Mazda", "e857kx", 2003, "white", true),
                new Car("BMW", "k123kk", 2017, "black", true),
                new Car("Mercedes", "c777cc", 2022, "red", true),
                new Car("Lada", "m693pa", 1997, "yellow", false)
        };

        File carCatalogPath = new File("./resource/carCatalog.txt");

        try(FileWriter writer = new FileWriter(carCatalogPath)) {
                for (Car car : cars) {
                    writer.write(car.prepareCarToWriteToFile());
                    writer.append('\n');
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}