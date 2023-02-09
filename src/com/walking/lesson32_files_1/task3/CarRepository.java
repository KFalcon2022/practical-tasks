package com.walking.lesson32_files_1.task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CarRepository {
    private File carCatalogPath;
    private String[] carsStringArray;

    public CarRepository(File carCatalogPath) {
        this.carCatalogPath = carCatalogPath;
    }

    public void writeToFile(Car[] cars) {
        try (FileOutputStream carOutputStream = new FileOutputStream(carCatalogPath)) {
            for (Car car : cars) {
                byte[] buffer = car.prepareCarToWriteToFile().getBytes();

                carOutputStream.write(buffer);
                carOutputStream.write('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] readFromFile() {
        try (FileInputStream carInputStream = new FileInputStream(carCatalogPath)) {
            byte[] bytes = new byte[(int) carCatalogPath.length()];

            carInputStream.read(bytes);

            String fileContent = new String(bytes);

            carsStringArray = fileContent.split("\\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return carsStringArray;
    }

    public Car getCarFromString(String carStr) {
        String[] carData = carStr.split(";");

        String brand = carData[0];
        String number = carData[1];
        int year = Integer.parseInt(carData[2]);
        String color = carData[3];
        boolean actualTechnicalInspection = carData[4].equals("true");

        return  new Car(brand, number, year, color, actualTechnicalInspection);
    }

    public Car[] createCarArray() {
        String[] carsString = readFromFile();

        Car[] cars = new Car[carsString.length];

        for (int i = 0; i < carsString.length; i++) {
            cars[i] = getCarFromString(carsString[i]);
        }

        return cars;
    }

    public void addCarToFile(Car car) {
        try (FileOutputStream carOutputStream = new FileOutputStream(carCatalogPath, true)) {
            byte[] buffer = car.prepareCarToWriteToFile().getBytes();

            carOutputStream.write(buffer);
            carOutputStream.write('\n');

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCarFromFile(Car car) {
        Car[] cars = createCarArray();
        Car[] newCars = new Car[cars.length - 1];
        int index = 0;

        for (int i = 0; i < cars.length; i++) {
            if (car.equals(cars[i])) {
                index = i;
            }
        }

        for (int i = 0; i < cars.length; i++) {
            if (i != index) {
                int newIndex = i < index ? i : i - 1;
                newCars[newIndex] = cars[i];
            }
        }

        writeToFile(newCars);
    }

    public void changeCarData(Car car, String color, boolean actualTechnicalInspection) {
        Car[] cars = createCarArray();

        for (Car carArray : cars) {
            if (car.equals(carArray)) {
                carArray.setColor(color);
                carArray.setActualTechnicalInspection(actualTechnicalInspection);
            }
        }

        writeToFile(cars);
    }
}
