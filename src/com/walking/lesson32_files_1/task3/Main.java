package com.walking.lesson32_files_1.task3;

import com.walking.lesson32_files_1.task3.model.Car;
import com.walking.lesson32_files_1.task3.model.CarColor;
import com.walking.lesson32_files_1.task3.service.CarRepository;
import com.walking.lesson32_files_1.task3.service.CarService;

/**
 * Реализуйте возможность добавления, удаления и изменения информации о машинах,
 * используя Задачи 1 и 2.
 * Работу с файлом предлагаю вынести в класс CarRepository,
 * но вы можете сделать иную реализацию на свое усмотрение.
 */
public class Main {
    public static void main(String[] args) {
        Car[] testCars = createCars();

        CarRepository carRepository = new CarRepository("./practical-tasks/resource/lesson31/carCatalog.txt");

        //сохранение
        carRepository.save(testCars);

        //загрузка
        testCars = carRepository.load();

        System.out.println("Машины после создания, сохранения в файл и загрузки из файла:");
        displayCars(testCars);

        CarService carService = new CarService(testCars);

        //добавление
        carService.add(new Car("Q123WE", 1990, CarColor.VIOLET, false));

        System.out.println("Машины после добавления:");
        displayCars(carService.getOriginalCars());

        //удаление
        carService.delete(new Car("A123BC", 2024, CarColor.RED, false));

        System.out.println("Машины после удаления:");
        displayCars(carService.getOriginalCars());

        //изменение информации
        Car carToChange = new Car("Z000ZZ", 2000, CarColor.YELLOW, true);

        if ((carToChange = carService.find(carToChange) ) != null) {

            carToChange.setColor(CarColor.INDIGO);
            carToChange.setHasFine(false);
        }

        System.out.println("Машины после изменения:");
        displayCars(carService.getOriginalCars());
    }

    public static Car[] createCars() {
        return new Car[]{new Car("A123BC", 2024, CarColor.RED, false),
                         new Car("Z000ZZ", 2000, CarColor.YELLOW, true),
                         new Car("F999FF", 1970, CarColor.BLACK, true)};
    }

    public static void displayCars(Car[] cars) {
        System.out.println("-".repeat(56));

        for (Car car : cars) {
            System.out.println(car);
        }

        System.out.println();
    }
}
