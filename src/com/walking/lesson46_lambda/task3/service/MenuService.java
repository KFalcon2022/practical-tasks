package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.domain.MainMenuItem;
import com.walking.lesson46_lambda.task3.domain.filter.*;
import com.walking.lesson46_lambda.task3.model.Car;

import java.util.Set;

public class MenuService {
    private final CarService carService;
    private final InputService inputService;
    private final MenuMappingService mappingService;
    private final MessagePrinterService messagePrinterService;
    private final InputValidationService inputValidationService;

    public MenuService(CarService carService, InputService inputService, MenuMappingService mappingService,
                       MessagePrinterService messagePrinterService, InputValidationService inputValidationService) {
        this.carService = carService;
        this.inputService = inputService;
        this.mappingService = mappingService;
        this.messagePrinterService = messagePrinterService;
        this.inputValidationService = inputValidationService;
    }

    public void processMainMenu() {
        boolean isExit = false;
        while (!isExit) {
            messagePrinterService.printMainMenuMessage();

            String menuItemInput = inputService.getLine();
            MainMenuItem item = mappingService.mapMainMenuItem(menuItemInput);
//            Обратите внимание на упрощенный синтаксис switch-case
            switch (item) {
                case SEARCH_BY_NUMBER -> processSearchByNumber();
                case SEARCH_BY_NUMBER_SUBSTRING -> processSearchByNumberSubstring();
                case SEARCH_BY_COLOR -> processSearchByColor();
                case SEARCH_BY_YEAR_BETWEEN -> processSearchByYearBetween();
                case EXIT -> isExit = true;
                case INCORRECT_CHOICE -> messagePrinterService.printIncorrectInputMessage();
                default -> throw new RuntimeException("Unknown main menu item: %s".formatted(item));
            }
        }
    }

    private void processSearchByNumber() {
        messagePrinterService.printSearchByNumberMessage();
        String number = inputService.getLine();

        processSearch(new NumberCarFilter(number));
    }

    private void processSearchByNumberSubstring() {
        messagePrinterService.printSearchByNumberSubstringMessage();
        String numberSubstring = inputService.getLine();

        processSearch(new NumberSubstringCarFilter(numberSubstring));

    }

    private void processSearchByColor() {
        messagePrinterService.printSearchByColorMessage();
        String color = inputService.getLine();

        processSearch(new ColorCarFilter(color));
    }

    private void processSearchByYearBetween() {
        messagePrinterService.printSearchByYearBetweenMessage();

        messagePrinterService.printSearchByYearBetweenFirstInputMessage();
        int minYear = getMinYear();

        messagePrinterService.printSearchByYearBetweenSecondInputMessage();
        int maxYear = getMaxYear(minYear);

        processSearch(new DateBetweenCarFilter(minYear, maxYear));
    }

    private void processSearch(CarFilter filter) {
        Set<Car> cars = carService.findCars(car -> filter.filter(car));

        if (cars.isEmpty()) {
            messagePrinterService.printEmptyResultMessage();
            return;
        }

        cars.forEach(car -> System.out.println(car));
    }

    private int getMinYear() {
        String minYearInput = inputService.getLine();
        while (!inputValidationService.isMinYearInputValid(minYearInput)) {
            messagePrinterService.printIncorrectInputMessage();
            minYearInput = inputService.getLine();
        }

        return Integer.parseInt(minYearInput);
    }

    private int getMaxYear(int minYear) {
        String maxYearInput = inputService.getLine();
        while (!inputValidationService.isMaxYearInputValid(maxYearInput, minYear)) {
            messagePrinterService.printIncorrectInputMessage();
            maxYearInput = inputService.getLine();
        }

        return Integer.parseInt(maxYearInput);
    }
}
