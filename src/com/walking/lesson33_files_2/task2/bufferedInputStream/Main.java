package com.walking.lesson33_files_2.task2.bufferedInputStream;

import com.walking.lesson32_files_1.task2.Car;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File carCatalogPath = new File("./resource/carCatalog.txt");

        Car[] cars = getCarArray(carCatalogPath);

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static Car[] getCarArray(File carCatalogPath) {
        String[] carsString = read(carCatalogPath);

        Car[] cars = new Car[carsString.length];

        for (int i = 0; i < carsString.length; i++) {
            cars[i] = getCar(carsString[i]);
        }

        return cars;
    }

    private static String[] read(File carCatalogPath) {
        String[] carsStringArray;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(carCatalogPath))) {
            byte[] bytes = new byte[(int) carCatalogPath.length()];

            bis.read(bytes);

            String fileContent = new String(bytes);

            carsStringArray = fileContent.split("\\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return carsStringArray;
    }

    private static Car getCar(String carStr) {
        String[] carData = carStr.split(";");

        String brand = carData[0];
        String number = carData[1];
        int year = Integer.parseInt(carData[2]);
        String color = carData[3];
        boolean actualTechnicalInspection = carData[4].equals("true");

        return  new Car(brand, number, year, color, actualTechnicalInspection);
    }
}