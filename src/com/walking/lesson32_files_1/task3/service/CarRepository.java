package com.walking.lesson32_files_1.task3.service;

import com.walking.lesson32_files_1.task3.model.Car;

import java.io.*;

public class CarRepository {
    public final String pathToFile;

    public CarRepository(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public void changeCar(Car requiredCar, Car newInformationCar) {
        String desiredCar = requiredCar.toString();
        String carCatalog = readCarCatalog();

        if (!carCatalog.contains(desiredCar)) {
            throw new RuntimeException("Desired car not found");
        }

        try (FileWriter carCatalogWriter = new FileWriter(pathToFile)) {
            String[] carCatalogArray = carCatalog.split("\\n");
            for (String someCar : carCatalogArray) {
                if ((someCar.compareTo(desiredCar)) == 0) {
                    someCar = newInformationCar.toString();
                }

                carCatalogWriter.write(someCar + "\n");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Record is over");
    }

    public void addNewCar(Car newCar) {
        String newCarInformation = newCar.toString();

        try (FileWriter changeCarCatalog = new FileWriter(pathToFile, true)) {
            changeCarCatalog.write(newCarInformation + "\n");
            System.out.println("Adding is over");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeCarCatalog(Car[] cars) {
        try (FileOutputStream carCatalog = new FileOutputStream(pathToFile, false)) {
            for (Car car : cars) {
                String carsInformation = car.toString();
                byte[] bytesCarInformation = carsInformation.getBytes();

                carCatalog.write(bytesCarInformation);
                carCatalog.write("\n".getBytes());
            }

            System.out.println("Recording is over");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Car[] getCarCatalog() {
        String carCatalog = readCarCatalog();
        String[] carsArray = carCatalog.split("\n");
        Car[] cars = new Car[carsArray.length];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = parseCar(carsArray[i].split(";"));
        }

        return cars;
    }

    public String readCarCatalog() {
        StringBuilder fileLine = new StringBuilder();
        try (FileInputStream carCatalogueReader = new FileInputStream(pathToFile)) {
            int i;

            while ((i = carCatalogueReader.read()) != -1) {
                fileLine.append((char) i);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileLine.toString();
    }

    private Car parseCar(String[] carInformation) {
        String number = carInformation[0];
        int year = Integer.parseInt(carInformation[1]);
        String color = carInformation[2];

        return new Car(number, year, color);
    }
}
