package com.walking.lesson61_synchronized.service;

import com.walking.lesson61_synchronized.model.Car;
import com.walking.lesson61_synchronized.model.CarIdentificator;

import java.util.*;

public class CarService {
    private final Map<CarIdentificator, Car> cars = new HashMap<>();

    private Car searchResult;

    public void add(Car... inputCars) {
        new Thread(getAddingTask(inputCars)).start();
    }

    public void delete(Car... inputCars) {
        new Thread(getDeletingTask(inputCars)).start();
    }

    public void change(Car inputCar) {
        Car changedCar = createCarFromInput(inputCar);
        new Thread(getChangingTask(changedCar)).start();
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
                            if (cars.containsKey(car.getCarIdentificator())) {
                                System.out.println("\nThis car is already in list: " + car + "\n");
                            } else {
                                cars.put(car.getCarIdentificator(), car);
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
                            if (!cars.remove(car.getCarIdentificator(), car))
                                System.out.println("\n" + CarServicePrintMessages.CAR_NOT_FOUND + car + "\n");
                        });
            }
            System.out.println("Deleting in thread: " + Thread.currentThread().getName());
        };
    }

    private Runnable getChangingTask(Car changedCar) {
        Car oldCar = cars.get(changedCar.getCarIdentificator());

        return () -> {
            synchronized (cars) {
                if (!cars.containsKey(oldCar.getCarIdentificator())) {
                    throw new RuntimeException("Car to change doesn't exist!");
                }

                oldCar.setColor(changedCar.getColor());
            }
        };
    }

    private Runnable getSearchingTask(Car inputCar) {
        return () -> {
            synchronized (cars) {
                if (!cars.containsKey(inputCar.getCarIdentificator())) {
                    throw new RuntimeException(CarServicePrintMessages.CAR_SEARCH_ERROR);
                }
                searchResult = cars.get(inputCar.getCarIdentificator());
            }
        };
    }

    public String getCarList() {
        synchronized (cars) {
            return cars.toString();
        }
    }

    private Car createCarFromInput(Car carToChange) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(CarServicePrintMessages.CAR_GET_PARAMETERS_INDEX_MESSAGE);
        int parameterIndex = Integer.parseInt(scanner.nextLine());

        System.out.print(CarServicePrintMessages.CAR_GET_PARAMETER_MESSAGE);
        var parameter = scanner.next();

        return switch (parameterIndex) {
            case 1 -> new Car(carToChange.getCarIdentificator(), parameter);

            default -> throw new RuntimeException(CarServicePrintMessages.PARAMETER_CHOOSING_ERROR);
        };
    }
}
