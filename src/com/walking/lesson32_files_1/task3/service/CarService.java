package com.walking.lesson32_files_1.task3.service;
import com.walking.lesson21_immutable_object.car.Car;
import com.walking.lesson32_files_1.task3.repository.CarRepository;

import java.util.Arrays;

public class CarService {
    public final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository  = repository;
    }

    public void addCar(Car car) {
        if (find(car) != null) {
            System.out.println("Такая машина уже существует.");
            return;
        }

        int length = repository.carsArr.length;
        repository.carsArr = Arrays.copyOf(repository.carsArr, length + 1);
        repository.carsArr[length - 1] = car;
        System.out.println("Машина добавлена.");
    }

    public void update(Car car) {
        Car existedCar = find(car);

        if (existedCar == null) {
            System.out.println("Машина не найдена.");
            return;
        }

        existedCar.setOwner(car.getOwner());
        System.out.println("Информация о владельце обновлена.");
    }

    public void delete(Car car) {
        int index = getIndex(car);
        if (index == -1) {
            System.out.println("Машина не найдена.");
            return;
        }

        int length = repository.carsArr.length;
        Car[] updatedCars = new Car[length - 1];
        for (int i = 0; i < length; i++) {
            if (i < index) {
                updatedCars[i] = repository.carsArr[i];
            }

            if (i > index) {
                updatedCars[i - 1] = repository.carsArr[i];
            }
        }

        repository.carsArr = updatedCars;
        System.out.println("Машина удалена.");
    }

    public Car[] getCars() {
        return repository.carsArr;
    }

    private Car find(Car car) {
        for (Car c : repository.carsArr) {
            if (c.equals(car)) {
                return c;
            }
        }
        return null;
    }

    private int getIndex(Car car) {
        for (int i = 0; i < repository.carsArr.length; i++) {
            if (repository.carsArr[i].equals(car)) {
                return i;
            }
        }
        return -1;
    }
}
