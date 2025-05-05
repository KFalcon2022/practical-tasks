package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.filter.ColorFilter;
import com.walking.lesson46_lambda.task3.filter.NumberFilter;
import com.walking.lesson46_lambda.task3.filter.NumberSubstringFilter;
import com.walking.lesson46_lambda.task3.filter.YearFilter;
import com.walking.lesson46_lambda.task3.model.Car;

import java.util.Set;
import java.util.function.Predicate;

public class LauncherService {
    private final InputService inputService;
    private final InputValidationService inputValidationService;
    private final CarService carService;
    private final PrintMessageService printMessageService;

    public LauncherService(InputService inputService, InputValidationService inputValidationService, CarService carService, PrintMessageService printMessageService) {
        this.inputService = inputService;
        this.inputValidationService = inputValidationService;
        this.carService = carService;
        this.printMessageService = printMessageService;
    }

    public void start() {
        boolean isExit = false;

        while (!isExit) {
            printMessageService.printStartMenuMessage();

            String userInput = inputService.getInput();

            switch (Integer.parseInt(userInput)) {
                case 0 -> isExit = true;
                case 1 -> findByNumber();
                case 2 -> findByNumberSubstring();
                case 3 -> findByColor();
                case 4 -> findByYear();
                default -> printMessageService.printUnknownCommandMessage();
            }
        }
    }

    private void findByNumberSubstring() {
        printMessageService.printEnterTheNumberSubstringMessage();
        String number = inputService.getInput();
        printMessageService.printEmptyLine();

        search(new NumberSubstringFilter(number));
    }

    private void findByYear() {
        printMessageService.printEnterTheMinYearMessage();
        int minYear = Integer.parseInt(inputService.getInput());
        printMessageService.printEnterTheMaxYearMessage();
        int maxYear = Integer.parseInt(inputService.getInput());
        printMessageService.printEmptyLine();

        search(new YearFilter(minYear, maxYear));
    }

    private void findByNumber() {
        printMessageService.printEnterTheNumberMessage();
        String number = inputService.getInput();
        printMessageService.printEmptyLine();

        search(new NumberFilter(number));
    }

    private void findByColor() {
        printMessageService.printEnterTheColorMessage();
        String color = inputService.getInput();
        printMessageService.printEmptyLine();

        search(new ColorFilter(color));
    }

    private void search(Predicate<Car> predicate) {
        Set<Car> cars = carService.findCars(car -> predicate.test(car));

        if (cars.isEmpty()) {
            printMessageService.printNoMatchesFoundMessage();
            return;
        }

        cars.forEach(car -> System.out.println(car));
        printMessageService.printEmptyLine();
    }
}
