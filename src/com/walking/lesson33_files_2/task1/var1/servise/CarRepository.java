
package com.walking.lesson33_files_2.task1.var1.servise;

import com.walking.lesson33_files_2.task1.var1.model.Car;

import java.io.*;

public class CarRepository {
    private File file;

    public CarRepository(File file) {
        this.file = file;
    }

    public void writeCar(Car[] cars) {

        try (FileWriter fileWriter = new FileWriter(file)) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < cars.length; i++) {
                stringBuilder.append("Car ")
                        .append(i + 1)
                        .append("\n")
                        .append(cars[i].toString());
            }

            //byte[] buffer = stringBuilder.toString().getBytes();

            //fileWriter.write(buffer, 0, buffer.length);

            fileWriter.write(stringBuilder.toString());

            System.out.println("Запись успешна");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Car[] readCar() {
        try (FileReader fileReader = new FileReader(file)) {
            //char[] buffer = new char[256];

            StringBuilder stringBuilder = new StringBuilder();

            int count;

            while ((count = fileReader.read()) != -1) {

                stringBuilder.append((char) count);

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
