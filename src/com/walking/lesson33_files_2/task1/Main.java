package com.walking.lesson33_files_2.task1;

import com.walking.lesson33_files_2.task1.Variants.MyBufferWriter;
import com.walking.lesson33_files_2.task1.Variants.MyBufferedOutputStream;
import com.walking.lesson33_files_2.task1.Variants.MyFileWriter;

import java.io.File;

/**
 * Реализуйте Задачу 1 из урока
 * <a href="https://telegra.ph/Rabota-s-fajlami-CHast-I-12-17">...</a>
 * с помощью:
 * <p>
 * Вариант 1: FileWriter;
 * Вариант 2: BufferedOutputStream;
 * Вариант 3: BufferedWriter.
 */
public class Main {
   public static File carCatalog = new File("./resource/carCatalog.txt");

    public static void main(String[] args) {

        Car[] cars = initCars();

        MyBufferWriter bufferWriter = new MyBufferWriter(cars);
        bufferWriter.writeInformation();

    }

    private static Car[] initCars() {

        Car car1 = new Car("BMW", "8765",2007 , "grey", true);
        Car car2 = new Car("Toyota", "6532", 1994, "White", false);
        Car car3 = new Car("Toyota", "1278", 2024, "Black", true);

        return new Car[]{car1, car2, car3};
    }

    private static String mapCarToFileView(Car car) {
        return "%s; %s; %d; %s; %b".formatted(
                car.getCarMake(), car.getCarNumber(), car.getYear(), car.getColor(), car.isActualRegistration());
    }
}
