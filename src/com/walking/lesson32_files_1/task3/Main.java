package com.walking.lesson32_files_1.task3;

import com.walking.lesson32_files_1.task3.model.Car;
import com.walking.lesson32_files_1.task3.repository.CarRepository;
import com.walking.lesson32_files_1.task3.service.CarService;

/**
 * Реализуйте возможность добавления, удаления и изменения информации о машинах,
 * используя Задачи 1 и 2.
 * Работу с файлом предлагаю вынести в класс CarRepository,
 * но вы можете сделать иную реализацию на свое усмотрение.
 */
public class Main {

    public static void main(String[] args) {
        Car[] cars = initCars();

        CarRepository carRepository = new CarRepository();
        carRepository.writeCarCatalog(cars);

        CarService carService = new CarService(carRepository.getCarCatalog());
        carService.add(new Car("EE-111-EE", 2025, "black"));
        carService.change(new Car("RR-222-RR", 2016, "pink"));
        carService.delete(new Car("RR-333-RR", 2017, "yellow"));

    }

    private static Car[] initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow");
        Car car2 = new Car("RR-222-RR", 2016, "yellow");
        Car car4 = new Car("RR-444-RR", 2018, "yellow");
        Car car5 = new Car("RR-555-RR", 2018, "yellow");
        Car car6 = new Car("RR-666-RR", 2018, "yellow");
        Car car7 = new Car("RR-777-RR", 2018, "yellow");
        Car car3 = new Car("RR-333-RR", 2017, "yellow");
        Car car8 = new Car("RR-888-RR", 2018, "yellow");
        Car car9 = new Car("RR-999-RR", 2018, "yellow");
        Car car10 = new Car("RR-000-RR", 2018, "yellow");

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
