package com.walking.lesson32_files_1.task1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args)  {
        Car[] cars = new Car[]{
                new Car("Mazda", "å857êõ", 2003, "white", true),
                new Car("BMW", "ê123êê", 2017, "black", true),
                new Car("Mercedes", "ñ777ññ", 2022, "red", true),
                new Car("Lada", "ì693ðà", 1997, "yellow", false)
        };
        try (FileOutputStream carOutputStream = new FileOutputStream("./resource/carCatalog.txt", true)) {
            String line = "_______________\n";

            for (Car car : cars) {
                byte[] buffer = car.toString().getBytes();

                carOutputStream.write(buffer);
                carOutputStream.write(line.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
