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
        CarService carService=new CarService();
        carService.addCar(new Car("Reno", "Logan", "White", 2010));
        carService.addCar(new Car("Reno", "Logan", "White", 2020));
        carService.addCar(new Car("Lada", "Vesta", "Black", 2015));
        carService.getCars(car->car.getColor()=="White").forEach(car->{System.out.println(car.getYear());});
        System.out.println(carService.getCar(carService.getCars(car->car.getColor()=="White").getFirst()));
        carService.delCar(0);
        carService.getCars(car->car.getColor()=="White").forEach(car->{System.out.println(car.getYear());});
    }
}