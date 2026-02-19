package com.walking.lesson33_files_2.task2.var3;

import com.walking.lesson33_files_2.model.Car;

import java.io.*;

public class Main {
    public static final String CAR_CATALOG_FILE_PATH = "./resource/files/lesson33_files_2/task2/var3/carCatalog.txt";

    public static void main(String[] args) {
        File carCatalogFile = new File(CAR_CATALOG_FILE_PATH);
        String carCatalogText = readCarCatalog(carCatalogFile);
        Car[] cars = getCars(carCatalogText.split("\n"));

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static Car[] getCars(String[] carCatalogText) {
        Car[] cars = new Car[carCatalogText.length];

        for (int i = 0; i < carCatalogText.length; i++) {
            cars[i] = parseCar(carCatalogText[i].split(";"));
        }

        return cars;
    }

    private static String readCarCatalog(File carCatalogFile) {
        StringBuilder carCatalogText = new StringBuilder();

        if (carCatalogFile.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(carCatalogFile))) {
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    carCatalogText.append(s);
                    carCatalogText.append("\n");

                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return carCatalogText.toString();
    }

    private static Car parseCar(String[] carInformation) {
        String number = carInformation[0];
        int year = Integer.parseInt(carInformation[1]);
        String color = carInformation[2];

        return new Car(number, year, color, true);
    }
}
