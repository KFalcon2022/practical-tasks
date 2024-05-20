package com.walking.lesson33_files_2.task1.Variants;

import com.walking.lesson33_files_2.task1.Car;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static com.walking.lesson33_files_2.task1.Main.carCatalog;

public class MyBufferWriter implements WriterInterface{
    private Car[] cars;

    public MyBufferWriter(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public void writeInformation() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(carCatalog))) {

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
