package com.walking.lesson61_synchronized;

import com.walking.lesson61_synchronized.model.Car;
import com.walking.lesson61_synchronized.service.CarService;

/**
 * Реализуйте сервис для работы с машинами.
 * Предусмотрите возможность добавления, удаления машин,
 * изменения информации о существующей машине, а также поиск по доступным машинам.
 * Обеспечьте потокобезопасность разработанного сервиса.
 */
public class Main {
    public static void main(String[] args) {
        CarService service = new CarService();

        service.addCar(new Car("RRR-123-XX", 2024, "silver", true));
        //service.printCars();

        service.deleteCar(new Car("RRR-111-XX", 2022, "gold", true)); // удаление должно быть по CarIdentifier
        service.printCars();

        Car car = service.findCar(new Car("RRR-111-XX", 2024, "red", true));  //поиск дожен быть по CarIdentifier
        System.out.println(car);
    }
}