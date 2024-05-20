package com.walking.lesson32_files_1.task3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CarRepository {
    private static final String CAR_CATALOG_PATH = "./resource/carCatalog.txt";

    public void saveCars(Car[] cars) {
        try (FileOutputStream fos = new FileOutputStream(CAR_CATALOG_PATH)) {

            for (Car car : cars) {
                fos.write(mapCarToFileView(car).getBytes());
                fos.write('\n');
            }
        } catch (IOException exception) {

            System.out.println(exception.getMessage());
        }
    }

    public void readFile() {
        try (FileInputStream fin = new FileInputStream(CAR_CATALOG_PATH)) {

            int i;
            while ((i = fin.read()) != -1) {

                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String mapCarToFileView(Car car) {
        return "%s; %s; %d; %s; %b".formatted(
                car.getCarMake(), car.getCarNumber(), car.getYear(), car.getColor(), car.isActualRegistration());
    }
}
