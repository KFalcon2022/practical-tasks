package com.walking.lesson32_files_1.task3;

import com.walking.lesson32_files_1.task1.model.Car;
import com.walking.lesson32_files_1.task1.model.Specification;
import com.walking.lesson32_files_1.task3.service.CarService;

/**
 * Реализуйте возможность добавления, удаления и изменения информации о машинах,
 * используя Задачи 1 и 2.
 * Работу с файлом предлагаю вынести в класс CarRepository,
 * но вы можете сделать иную реализацию на свое усмотрение.
 */
public class Main {
    public static void main(String[] args) {
        CarService carService=new CarService();
        printCars(carService.getCars());
        printCars(carService.addCar(new Car("123", "awd12", new Specification("Toyota", "Corolla"), "Black"))); 
        printCars(carService.delCar(carService.getCars().length-1));
        printCars(carService.editCar(3, new Car("462", "sjnbaap10u0107597", new Specification("Nissan", "Primera"), "Blue")));
    }
    private static void printCars(Car[] cars){
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println("\n");
    }
}
