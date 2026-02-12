package com.walking.lesson33_files_2.task1.var2.servise;

import com.walking.lesson33_files_2.task1.var2.model.Car;

import java.io.*;

public class CarRepository {
    File dir = new File("./resources/files/lesson32/carCatalog.txt");

    public void writeCar(Car[] cars) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(dir);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream (fileOutputStream))
        {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < cars.length; i++) {
                stringBuilder.append("Car ")
                        .append(i + 1)
                        .append("\n")
                        .append(cars[i].toString());
            }

            byte[] buffer = stringBuilder.toString().getBytes();

            bufferedOutputStream.write(buffer, 0, buffer.length);



            System.out.println("Запись успешна\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Car[] readCar() {

        try (FileInputStream fileInputStream = new FileInputStream(dir);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream))
        {

            //byte[] buffer = new byte[256];


            StringBuilder stringBuilder = new StringBuilder();

            int count;

            while ((count = bufferedInputStream.read()) != -1) {

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
