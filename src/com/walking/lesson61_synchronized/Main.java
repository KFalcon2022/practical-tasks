package com.walking.lesson61_synchronized;

import com.walking.lesson61_synchronized.model.Car;
import com.walking.lesson61_synchronized.model.CarIdentificator;
import com.walking.lesson61_synchronized.service.CarArrayInitService;
import com.walking.lesson61_synchronized.service.CarInteractionService;

import java.util.Arrays;

/**
 * Реализуйте сервис для работы с машинами.
 * Предусмотрите возможность добавления, удаления машин,
 * изменения информации о существующей машине, а также поиск по доступным машинам.
 * Обеспечьте потокобезопасность разработанного сервиса.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Car[] cars = CarArrayInitService.createCarArray();
        CarInteractionService carService = new CarInteractionService();
        Arrays.stream(cars)
                .forEach(carService::add);

        System.out.println(carService.getCarList());

        carService.delete(new Car(new CarIdentificator("RR-444-RR", 2018), "red"));
        carService.delete(new Car(new CarIdentificator("RR-777-RR", 2018), "red"));
        carService.delete(new Car(new CarIdentificator("RR-777-RR", 2018), "black"));

        System.out.println(carService.getCarList());

        carService.change(new Car(new CarIdentificator("RR-111-RR", 2015), "yellow"));
        System.out.println(carService.getCarList());

        carService.change(new Car(new CarIdentificator("RR-000-RR", 2018), "yellow"));
        System.out.println(carService.getCarList());

        System.out.println(carService.search(new Car(new CarIdentificator("RR-666-RR", 2018), "black")));

    }
}