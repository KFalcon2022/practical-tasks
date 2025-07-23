package com.walking.lesson32_files_1.task3;

import com.walking.lesson21_immutable_object.car.Car;
import com.walking.lesson32_files_1.task3.repository.CarRepository;
import com.walking.lesson32_files_1.task3.service.CarService;

import java.io.IOException;

/**
 * Реализуйте возможность добавления, удаления и изменения информации о машинах,
 * используя Задачи 1 и 2.
 * Работу с файлом предлагаю вынести в класс CarRepository,
 * но вы можете сделать иную реализацию на свое усмотрение.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        CarRepository repository = new CarRepository();
        repository.saveAll(setCars());
        repository.findAll();

        CarService service = new CarService(repository);
        service.addCar(new Car("Волга", "Курочкин Л.Д.", "зщ876е"));
        service.update(new Car("Audi", "Вовочкин Д.Е.", "уе777к"));
        service.delete(new Car("Ford", "Снегирь Ю.В.", "мр666м"));

        repository.saveAll(service.getCars());
    }

    private static Car[] setCars() {
        Car[] cars = new Car[6];
        cars[0] = new Car("Audi", "Печкин Ф.Б.", "уе777к");
        cars[1] = new Car("BMW", "Борисов Ю.А.", "ос025р");
        cars[2] = new Car("Ford", "Снегирь Ю.В.", "мр666м");
        cars[3] = new Car("Bentley", "Белова Д.М.", "ра345з");
        cars[4] = new Car("Ferrari", "Сергеев К.Л.", "уе999з");
        cars[5] = new Car("Москвич", "Попов А.Д.", "ар832с");

        return cars;
    }
}
