package com.walking.lesson61_synchronized;

import com.walking.lesson61_synchronized.model.Car;
import com.walking.lesson61_synchronized.model.Color;
import com.walking.lesson61_synchronized.repository.CarRepository;
import com.walking.lesson61_synchronized.service.CarService;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализуйте сервис для работы с машинами.
 * Предусмотрите возможность добавления, удаления машин,
 * изменения информации о существующей машине, а также поиск по доступным машинам.
 * Обеспечьте потокобезопасность разработанного сервиса.
 */
public class Main {
    public static void main(String[] args) {
        CarRepository carRepository = new CarRepository();
        carRepository.saveAll(initCars());

        CarService carService = new CarService(carRepository.findAll());

        Car car = carService.find(new Car("RR-111-RR", 2015));
        car.setColor(Color.GREEN);
        carService.update(car);

        carService.delete(new Car("RR-999-RR", 2018));
        carService.delete(new Car("RR-000-RR", 2018));

        carService.add(new Car("NN-111-NN", 2022, Color.BLACK, true));

        carRepository.saveAll(carService.getAll());
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("RR-111-RR", 2015, Color.YELLOW, true));
        cars.add(new Car("RR-222-RR", 2016, Color.YELLOW, true));
        cars.add(new Car("RR-333-RR", 2017, Color.YELLOW, true));
        cars.add(new Car("RR-444-RR", 2018, Color.YELLOW, true));
        cars.add(new Car("RR-555-RR", 2018, Color.YELLOW, true));
        cars.add(new Car("RR-666-RR", 2018, Color.YELLOW, true));
        cars.add(new Car("RR-777-RR", 2018, Color.YELLOW, true));
        cars.add(new Car("RR-888-RR", 2018, Color.YELLOW, true));
        cars.add(new Car("RR-999-RR", 2018, Color.YELLOW, true));
        cars.add(new Car("RR-000-RR", 2018, Color.YELLOW, true));

        return cars;
    }
}