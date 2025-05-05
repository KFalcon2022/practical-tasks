package com.walking.lesson33_files_2.task1.Variants;

import com.walking.lesson33_files_2.task1.Car;
import com.walking.lesson33_files_2.task1.Main;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class MyBufferedOutputStream implements WriterInterface {

    private Car[] cars;

    public MyBufferedOutputStream(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public void writeInformation() {

        try (FileOutputStream fos = new FileOutputStream(Main.carCatalog);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fos)) {

            for (Car car : cars) {
                bufferedOutputStream.write(mapCarToFileView(car).getBytes());
                bufferedOutputStream.write('\n');
            }

        } catch (IOException exception) {

            System.out.println(exception.getMessage());
        }

    }

    private static String mapCarToFileView(Car car) {
        return "%s; %s; %d; %s; %b".formatted(
                car.getCarMake(), car.getCarNumber(), car.getYear(), car.getColor(), car.isActualRegistration());
    }
}
