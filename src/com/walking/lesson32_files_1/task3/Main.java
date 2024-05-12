package com.walking.lesson32_files_1.task3;

import com.walking.lesson32_files_1.task3.model.Car;
import com.walking.lesson32_files_1.task3.model.Color;
import com.walking.lesson32_files_1.task3.service.CarService;

import java.io.File;

/**
 * Реализуйте возможность добавления, удаления и изменения информации о машинах,
 * используя Задачи 1 и 2.
 * Работу с файлом предлагаю вынести в класс CarRepository,
 * но вы можете сделать иную реализацию на свое усмотрение.
 */
public class Main {
    public static void main(String[] args) {
        File carCatalog = new File("./practical-tasks/resource/lesson32/carCatalog.txt");

        CarService carService = new CarService(carCatalog);

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