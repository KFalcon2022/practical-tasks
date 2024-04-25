package com.walking.lesson33_files_2.task1;

import com.walking.lesson33_files_2.task1.model.Car;
import com.walking.lesson33_files_2.task1.model.Color;
import com.walking.lesson33_files_2.task1.repository.CarRepository;
import com.walking.lesson33_files_2.task1.service.CarService;

import static com.walking.lesson33_files_2.task1.repository.CarRepository.*;

import java.io.*;

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
    public static void main(String[] args) {
        /* BufferedReader + BufferedWriter */
        File defaultCatalog = new File("./practical-tasks/resource/lesson33/carCatalog.txt");
        CarService withDefaultRepository = new CarService(defaultCatalog);

        testAddDeleteEdit(withDefaultRepository);

        /* FileReader + FileWriter */
        File customCatalog = new File("./practical-tasks/resource/lesson33/customCatalog.txt");
        CarRepository customRepository = getOfIoType(customCatalog, InputType.FILE_READER, OutputType.FILE_WRITER);
        CarService withCustomRepository = new CarService(customRepository);

        testAddDeleteEdit(withCustomRepository);

        /* BufferedInputStream + BufferedOutputStream */
        File customCatalog1 = new File("./practical-tasks/resource/lesson33/customCatalog1.txt");
        CarRepository customRepository1 = getOfIoType(customCatalog1, InputType.BUFFERED_INPUT_STREAM, OutputType.BUFFERED_OUTPUT_STREAM);
        CarService withCustomRepository1 = new CarService(customRepository1);

        testAddDeleteEdit(withCustomRepository1);
    }

    public static void testAddDeleteEdit(CarService carService) {
        System.out.println("Машины в репозитории после инициализации сервиса:");
        carService.displayCars();

        //добавление
        carService.add(new Car("A123BC", 2024, Color.RED, false));
        carService.add(new Car("Z000ZZ", 2000, Color.YELLOW, true));
        carService.add(new Car("F999FF", 1970, Color.BLACK, true));

        System.out.println("Машины после добавления:");
        carService.displayCars();

        //удаление
        carService.remove(new Car("A123BC", 2024, Color.RED, false));

        System.out.println("Машины после удаления:");
        carService.displayCars();

        //изменение информации
        Car sampleCar = new Car("Z000ZZ", 2000, Color.YELLOW, true);
        Car foundCar = carService.find(sampleCar);

        if (foundCar != null) {
            foundCar.setColor(Color.INDIGO);
            foundCar.setFine(false);

            carService.update();
        }

        System.out.println("Машины после изменения:");
        carService.displayCars();
    }
}
