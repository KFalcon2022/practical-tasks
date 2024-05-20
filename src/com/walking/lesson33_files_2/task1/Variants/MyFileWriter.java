package com.walking.lesson33_files_2.task1.Variants;

import com.walking.lesson33_files_2.task1.Car;
import com.walking.lesson33_files_2.task1.Main;

import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter implements WriterInterface {

    private Car[] cars;

    public MyFileWriter(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public void writeInformation() {
        try (FileWriter writer = new FileWriter(Main.carCatalog)) {

            for (Car car : cars) {
                writer.write(mapCarToFileView(car));
                writer.write('\n');
            }
        } catch (IOException exception) {

            System.out.println(exception.getMessage());
        }
    }

    private static String mapCarToFileView(Car car) {
        return "%s; %s; %d; %s; %b".formatted(car.getCarMake(), car.getCarNumber(), car.getYear(), car.getColor(), car.isActualRegistration());
    }
}
