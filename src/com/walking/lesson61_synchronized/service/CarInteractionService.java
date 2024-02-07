package com.walking.lesson61_synchronized.service;

import com.walking.lesson61_synchronized.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarInteractionService {
    private final List<Car> cars = new ArrayList<>();
    private Car searchResult;

    public CarInteractionService() {
    }

    public void add(Car... inputCars) {
        new Thread(getAddingTask(inputCars))
                .start();
    }

    public void delete(Car... inputCars) {
        new Thread(getDeletingTask(inputCars))
                .start();
    }

    public void change(Car inputCar) {
        Scanner scanner = new Scanner(System.in);
        new Thread(getChangingTask(inputCar, scanner)).start();
//        scanner.close();  Как правильно закрыть сканнер в приложении с многократным обращением к считыванию с клавиатуры?
    }

    public Car search(Car inputCar) throws InterruptedException {
        Thread searchThread = new Thread(getSearchingTask(inputCar));
        searchThread.start();
        searchThread.join();

        return searchResult;
    }

    private Runnable getAddingTask(Car... inputCars) {
        return () -> {
            synchronized (cars) {
                Arrays.stream(inputCars)
                        .forEach(car -> {
                            if (cars.contains(car)) {
                                System.out.println("\nThis car is already in list: " + car + "\n");
                            } else {
                                cars.add(car);
                            }
                        });
            }
            System.out.println("Adding in thread: " + Thread.currentThread().getName());
        };
    }

    private Runnable getDeletingTask(Car... inputCars) {
        return () -> {
            synchronized (cars) {
                Arrays.stream(inputCars)
                        .forEach(car -> {
                            if (!cars.remove(car))
                                System.out.println("\n" + CarServicePrintMessages.CAR_NOT_FOUND + car + "\n");
                        });
            }
            System.out.println("Deleting in thread: " + Thread.currentThread().getName());
        };
    }

    private Runnable getChangingTask(Car car, Scanner scanner) {
        synchronized (cars) {
            System.out.print(CarServicePrintMessages.CAR_GET_PARAMETERS_INDEX_MESSAGE);
            int parameterIndex = Integer.parseInt(scanner.nextLine());

            System.out.print(CarServicePrintMessages.CAR_GET_PARAMETER_MESSAGE);
            var parameter = scanner.next();

            return switch (parameterIndex) {
                case (1) -> () -> cars.get(
                                cars.indexOf(car))
                        .getCarIdentificator()
                        .setPlateNumber(parameter);
                case (2) -> () -> cars.get(
                                cars.indexOf(car))
                        .getCarIdentificator()
                        .setReleaseYear(
                                Integer.parseInt(parameter));
                case (3) -> () -> cars.get(
                                cars.indexOf(car))
                        .setColor(parameter);
                default -> throw new RuntimeException(CarServicePrintMessages.PARAMETER_CHOOSING_ERROR);
            };
        }
    }

    private Runnable getSearchingTask(Car inputCar) {
        return () -> {
            synchronized (cars) {
                if (cars.contains(inputCar)) {
                    searchResult = cars.get(cars.indexOf(inputCar));
                } else {
                    throw new RuntimeException(CarServicePrintMessages.CAR_SEARCH_ERROR);
                }
            }
        };
    }

    public String getCarList() {
        synchronized (cars) {
            return cars.toString();
        }
    }
}
