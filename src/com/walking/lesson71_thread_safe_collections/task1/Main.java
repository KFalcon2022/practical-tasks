package com.walking.lesson71_thread_safe_collections.task1;

import com.walking.lesson71_thread_safe_collections.task1.model.Car;
import com.walking.lesson71_thread_safe_collections.task1.service.CarService;

/**
 * Реализуйте Задачу из Урока 61,
 * используя потокобезопасные коллекции вместо механизма synchronized.
 * @see com.walking.lesson61_synchronized.Main
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