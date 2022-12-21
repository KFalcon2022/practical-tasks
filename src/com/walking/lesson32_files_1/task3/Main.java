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
        CarRepository carRepository = new CarRepository();
        carRepository.saveAll(initCars());

        CarService carService = new CarService(carRepository.findAll());

        Car car = carService.find(new Car("RR-111-RR", 2015));
        car.setColor("green");
        carService.update(car);

        carService.delete(new Car("RR-999-RR", 2018));
        carService.delete(new Car("RR-000-RR", 2018));

        carService.add(new Car("NN-111-NN", 2022, "black", true));

//        Читать и писать файл при каждом изменении дорого, поэтому в рамках программы чтение и запись оставим
//        разово для программы. Но такой подход чреват потерей изменений, если в программе возникнет
//        необработанное исключение
        carRepository.saveAll(carService.getAll());
    }

    private static Car[] initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "yellow", true);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true);
        Car car6 = new Car("RR-666-RR", 2018, "yellow", true);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true);
        Car car10 = new Car("RR-000-RR", 2018, "yellow", true);

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
