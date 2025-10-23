package com.walking.lesson32_files_1.task1.servise;

import com.walking.lesson32_files_1.task1.model.Car;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class CarRepository {
    public static void writeCar(Car[] cars) {

        try (FileOutputStream fileOutputStream = new FileOutputStream("./resources/files/lesson32/carCatalog.txt")) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < cars.length; i++) {
                stringBuilder.append("Car ")
                        .append(i + 1)
                        .append("\n")
                        .append(cars[i].toString());
            }

            byte[] buffer = stringBuilder.toString().getBytes();

            fileOutputStream.write(buffer, 0, buffer.length);

            System.out.println("Запись успешна");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Car[] readCar() {
        try (FileInputStream fileInputStream = new FileInputStream("./resources/files/lesson32/carCatalog.txt")) {
            byte[] buffer = new byte[256];

            StringBuilder stringBuilder = new StringBuilder();

            int count;

            while ((count = fileInputStream.read(buffer)) != -1) {

                for (int i = 0; i < count; i++) {

                    stringBuilder.append((char)(buffer[i]));

                }
            }

            return createCarsArray(stringBuilder);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Car[] createCarsArray(StringBuilder stringBuilder) {
        String[] strings = stringBuilder.toString().
                replaceAll("^Car\\s\\d\\n|Car\\s\\d\\n$", "") //удаление разделителей в
                .split("Car\\s\\d\\n");

        Car[] cars = new Car[strings.length];

        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];

            String[] propertiesCar = string.split("\\n");

            String number = propertiesCar[0].replace("number: ", "");

            int year = Integer.parseInt(propertiesCar[1].replace("year: ", ""));

            String color = propertiesCar[2].replace("color: ", "");

            boolean actualTechnicalInspection = propertiesCar[3].equals("actualTechnicalInspection: actual");

            cars[i] = new Car(number, year, color, actualTechnicalInspection);
        }
        return cars;
    }
}
