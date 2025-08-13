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

    public void write(Car[] cars) {
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

    public Car[] get() {
        String[] carsString = read();

        Car[] cars = new Car[carsString.length];

        for (int i = 0; i < carsString.length; i++) {
            cars[i] = getCar(carsString[i]);
        }

        return cars;
    }

    public void add(Car car) {
        try (FileOutputStream carOutputStream = new FileOutputStream(carCatalogPath, true)) {
            byte[] buffer = car.prepareCarToWriteToFile().getBytes();

            carOutputStream.write(buffer);
            carOutputStream.write('\n');

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Car car) {
        Car[] cars = get();
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

        write(newCars);
    }

    public void update(Car car, String color, boolean actualTechnicalInspection) {
        Car[] cars = get();

        for (Car carArray : cars) {
            if (car.equals(carArray)) {
                carArray.setColor(color);
                carArray.setActualTechnicalInspection(actualTechnicalInspection);
            }
        }

        write(cars);
    }

    private String[] read() {
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

    private Car getCar(String carStr) {
        String[] carData = carStr.split(";");

        String brand = carData[0];
        String number = carData[1];
        int year = Integer.parseInt(carData[2]);
        String color = carData[3];
        boolean actualTechnicalInspection = carData[4].equals("true");

        return  new Car(brand, number, year, color, actualTechnicalInspection);
    }
}
