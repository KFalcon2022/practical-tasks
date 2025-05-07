package com.walking.lesson32_files_1.task3.repository;

import com.walking.lesson32_files_1.task3.model.Car;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CarRepository {
    private final String CATALOG_PATH = "./resource/files/lesson32/carCatalog_3_lesson.txt";

    /*
    Читает файл и возвращает массив машин
     */
    private Car[] getCars() {
        try (FileInputStream fis = new FileInputStream(CATALOG_PATH)) {
            StringBuilder stringBuilder = new StringBuilder();

            int i;
            while((i = fis.read()) != -1) {
                stringBuilder.append((char) i);
            }

            String[] carsStringArray = getCarsStringArray(stringBuilder.toString());

            Car[] cars = new Car[carsStringArray.length];
            for (int j = 0; j < carsStringArray.length; j++) {
                cars[j] = parseCar(carsStringArray[j]);
            }

            return cars;

        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла.");
        }
    }

    /*
    Записывает в файл массив машин
     */
    public Car[] saveCars(Car[] cars) {
        try (FileOutputStream fos = new FileOutputStream(CATALOG_PATH)) {

            for (Car car : cars) {
                fos.write(writeCarFormatToFile(car).getBytes());
                fos.write('\n');
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private String[] getCarsStringArray(String cars) {
        String[] carsStringArray = cars.split("\n");
        return carsStringArray;
    }

    private Car parseCar(String stringCar) {
        String[] car = stringCar.split(";");

        String mark = car[0];
        String color = car[1];
        int yearManufacture = Integer.parseInt(car[2]);
        int stateNumber = Integer.parseInt(car[3]);

        return new Car(mark, color, yearManufacture, stateNumber);
    }

    private String writeCarFormatToFile(Car car) {
        return "%s;%s;%d;%d".formatted(car.getMark(), car.getColor(), car.getYearManufacture(), car.getStateNumber());
    }
}
