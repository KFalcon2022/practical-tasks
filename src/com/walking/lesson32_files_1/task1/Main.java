package com.walking.lesson32_files_1.task1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args)  {
        Car[] cars = new Car[]{
                new Car("Mazda", "857", 2003, "white", true),
                new Car("BMW", "123", 2017, "black", true),
                new Car("Mercedes", "777", 2022, "red", true),
                new Car("Lada", "693", 1997, "yellow", false)
        };
        try (FileOutputStream CarOutputStream = new FileOutputStream("./resource/carCatalog.txt", true)) {
            String line = "_______________";

            for (Car car : cars) {
                byte[] buffer = car.toString().getBytes();

                CarOutputStream.write(buffer);
                CarOutputStream.write(line.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
