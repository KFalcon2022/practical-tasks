package com.walking.lesson32_files_1.task1;

/**
 * Используя класс Car (или создав новый класс для сущности «машина», на ваше усмотрение) из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods/model">...</a>
 * Реализуйте сохранение массива машин в файл carCatalog.txt
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car("c111cc","green","kamaz");
        CarService cs = new CarService(true);
        cs.addCar(car, true);
        System.out.println(cs);
    }
}
