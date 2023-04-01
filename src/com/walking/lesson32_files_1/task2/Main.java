package com.walking.lesson32_files_1.task2;

import com.walking.lesson32_files_1.task1.model.Car;

import java.io.*;
import java.util.Arrays;

/**
 * Используя Задачу 1, реализуйте чтение из carCatalog.txt,
 * реализовав сохранение данных в массив Car.
 */
public class Main {
    public static void main(String[] args) {

        StringBuilder inputData = new StringBuilder();

        try (FileInputStream fin = new FileInputStream("./resources/carCatalog.txt")) {
            int i;
            while ((i = fin.read()) != -1) {
                inputData.append((char) i);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        int splitCounter = 0;
        for (int i = 0; i < inputData.length() - 1; i++) {
            if (inputData.charAt(i) == 10 && inputData.charAt(i + 1) == 10) {
                inputData.deleteCharAt(i + 1);
                splitCounter++;
            }
        }

        Car[] cars = new Car[splitCounter];
        String[] str = parseData(inputData);

        for (int i = 0; i < cars.length; i++){
            cars[i] = createNewCar(str);
            String[] str1 = new String[str.length - 4];

            for (int j = 0, k = 4; j < str.length - 4; j++, k++){
                str1[j] = str[k];
            }
            str = str1;

        }
        System.out.println(Arrays.toString(cars));
    }

    private static String[] parseData (StringBuilder data){

        String[] subStr = data.toString().split(".*: ");
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < subStr.length; i++) {
            str.append(subStr[i]);
        }

        return str.toString().split("\n");
    }

    private static Car createNewCar (String[] data){
        String number = data[0];
        int year = Integer.parseInt(data[1]);
        String color = data[2];
        boolean actualTechnicalInspection = data[3].equals("actual");


        return new Car(number, year, color, actualTechnicalInspection);
    }
}
