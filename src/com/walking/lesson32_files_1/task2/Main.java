package com.walking.lesson32_files_1.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File carCatalog = new File("./resource/carCatalog.txt");
        String[] carsStringArray;
        Car[] cars;

        try (FileInputStream carInputStream = new FileInputStream(carCatalog)) {
            byte[] bytes = new byte[(int) carCatalog.length()];

            carInputStream.read(bytes);

            String fileContent = new String(bytes);

            carsStringArray = fileContent.split("_+\\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        cars = createCarsArray(carsStringArray);

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public static Car getCarFromString(String carStr) {
        Car car;

        String editCarStr = carStr.replaceAll("(brand:)|(number:)|(year:)|(color:)|(actualTechnicalInspection:|\\n)", "");
        String[] s = editCarStr.trim().split("\\s+");

        String brand = s[0];
        String number = s[1];
        int year = Integer.parseInt(s[2]);
        String color = s[3];
        boolean actualTechnicalInspection = s[4].equals("true");

        car = new Car(brand, number, year, color, actualTechnicalInspection);

        return car;
    }

    public static Car[] createCarsArray(String[] carsStringArray) {
        Car[] cars = new Car[carsStringArray.length];

        for (int i = 0; i < carsStringArray.length; i++) {
            cars[i] = getCarFromString(carsStringArray[i]);
        }

        return cars;
    }
}