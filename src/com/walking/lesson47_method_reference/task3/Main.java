package com.walking.lesson47_method_reference.task3;

import com.walking.lesson47_method_reference.task3.model.Car;
import com.walking.lesson47_method_reference.task3.service.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализуйте Задачу 3 из урока 46,
 * описав все реализуемые фильтры через method reference’ы.
 * Рекомендую вынести функциональность формирования фильтров в отдельный сервис,
 * если это не было сделано ранее.
 */
public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(initCars());
        InputService inputService = new InputService();
        InputValidationService inputValidationService = new InputValidationService();
        MessagePrinterService messagePrinterService = new MessagePrinterService();
        MenuMappingService mappingService = new MenuMappingService(inputValidationService);

        MenuService menuService = new MenuService(carService, inputService, mappingService,
                messagePrinterService, inputValidationService);

        try {
            menuService.processMainMenu();
        } finally {
            inputService.destroy();
        }
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("RR-111-RR", 2015, "yellow", true));
        cars.add(new Car("RR-222-RR", 2016, "yellow", true));
        cars.add(new Car("RR-333-RR", 2017, "yellow", true));
        cars.add(new Car("RR-444-RR", 2018, "yellow", true));
        cars.add(new Car("RR-555-RR", 2018, "yellow", true));
        cars.add(new Car("RR-666-RR", 2018, "yellow", true));
        cars.add(new Car("RR-777-RR", 2018, "yellow", true));
        cars.add(new Car("RR-888-RR", 2018, "yellow", true));
        cars.add(new Car("RR-999-RR", 2018, "yellow", true));
        cars.add(new Car("RR-000-RR", 2018, "yellow", true));

        return cars;
    }
}
