package com.walking.lesson32_files_1.task3;

import com.walking.lesson32_files_1.task1.Car;

/**
 * Реализуйте возможность добавления, удаления и изменения информации о машинах,
 * используя Задачи 1 и 2.
 * Работу с файлом предлагаю вынести в класс CarRepository,
 * но вы можете сделать иную реализацию на свое усмотрение.
 */
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Audi", "A4", "9834", 2017);
        CarRepository repository = new CarRepository();
        repository.addCarToCatalog(car1);
    }
}
