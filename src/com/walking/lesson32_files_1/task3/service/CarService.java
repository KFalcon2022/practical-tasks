package com.walking.lesson32_files_1.task3.service;
import com.walking.lesson21_immutable_object.car.Car;
import com.walking.lesson32_files_1.task3.repository.CarRepository;

public class CarService {
    public final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository  = repository;
    }

    public void add(Car car) {
        if (find(car) != null) {
            System.out.println("Такая машина уже существует.");
            return;
        }

        repository.addCar(car);
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

        repository.deleteCar(index);
        System.out.println("Машина удалена.");
    }

    public Car[] getAll() {
        return repository.getCarsArr();
    }

    private Car find(Car car) {
        Car[] cars = getAll();
        for (Car c : cars) {
            if (c.equals(car)) {
                return c;
            }
        }
        return null;
    }

    private int getIndex(Car car) {
        Car[] cars = getAll();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].equals(car)) {
                return i;
            }
        }
        return -1;
    }
}
