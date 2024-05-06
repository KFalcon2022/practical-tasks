package com.walking.lesson32_files_1.task3;

import com.walking.lesson32_files_1.task1.Car;

import java.io.FileOutputStream;
import java.io.IOException;

public class CarRepository {


    public void addCarToCatalog(Car car) {
        try (FileOutputStream fos = new FileOutputStream("./resource/carCatalog.txt", true)) {
            fos.write(mapCarToFileView(car).getBytes());
            fos.write('\n');
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void updateCatalog() {

    }

    private static String mapCarToFileView(Car car) {
        return "%s; %s; %s; %d;".formatted(car.getCarMake(), car.getModel(), car.getCarNumber(), car.getYear());
    }
}
