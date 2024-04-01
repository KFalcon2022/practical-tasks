package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.domain.MainMenuItem;
import com.walking.lesson46_lambda.task3.domain.filter.*;
import com.walking.lesson46_lambda.task3.model.Car;

import java.util.Set;

public class MenuService {
    private final CarService carService;
    private final InputService inputService;
    private final InputValidationSrevice inputValidationSrevice;
    private final MenuMappingSrevice menuMappingSrevice;
    private final MessagePrinterSrevice messagePrinterSrevice;

    public MenuService(CarService carService,
                       InputService inputService,
                       InputValidationSrevice inputValidationSrevice,
                       MenuMappingSrevice menuMappingSrevice,
                       MessagePrinterSrevice messagePrinterSrevice) {
        this.carService = carService;
        this.inputService = inputService;
        this.inputValidationSrevice = inputValidationSrevice;
        this.menuMappingSrevice = menuMappingSrevice;
        this.messagePrinterSrevice = messagePrinterSrevice;
    }

    public void processMainMenu() {
        boolean isExit = false;
        while (!isExit) {
            messagePrinterSrevice.printMainMenuMessage();

            String mainMenuInputItem = inputService.getLine();
            MainMenuItem item = menuMappingSrevice.mapMainMenuItem(mainMenuInputItem);

            switch (item) {
                case SEARCH_BY_NUMBER -> processSearchByNumber();
                case SEARCH_BY_NUMBER_SUBSTRING -> processSearchByNumberSubstring();
                case SEARCH_BY_COLOR -> processSearchByColor();
                case SEARCH_BY_YEAR_BETWEEN -> processSearchByYearBetween();
                case EXIT -> isExit = true;
                case INCORRECT_INPUT -> messagePrinterSrevice.printIncorrectInputMessage();
                default -> throw new RuntimeException("Не известный выбор меню: %s".formatted(item));
            }
        }
    }

    private void processSearchByNumber() {
        messagePrinterSrevice.printSearchByNumberMessage();
        String numberSearch = inputService.getLine();

        processSearch(new NumberCarFilter(numberSearch));
    }

    private void processSearchByNumberSubstring() {
        messagePrinterSrevice.printSearchByNumberSubstringMessage();
        String numberSubstring = inputService.getLine();

        processSearch(new NumberSubstringCarFilter(numberSubstring));
    }

    private void processSearchByColor() {
        messagePrinterSrevice.printSearchByColorMessage();
        String color = inputService.getLine();

        processSearch(new ColorCarFilter(color));
    }

    private void processSearchByYearBetween() {
        messagePrinterSrevice.printSearchByYearBetweenMessage();

        messagePrinterSrevice.printSearchByYearBetweenFirstInputMessage();
        int minYear = getMinYear();

        messagePrinterSrevice.printSearchByYearBetweenSecondInputMessage();
        int maxYear = getMaxYear(minYear);

        processSearch(new YearBetweenCarFilter(minYear, maxYear));
    }

    private void processSearch(CarFilter filter) {
        Set<Car> cars = carService.searchCars(car -> filter.filter(car));

        if (cars.isEmpty()) {
            messagePrinterSrevice.printEmptyResultMessage();
        }

        cars.forEach(car -> System.out.println(car));
    }

    private int getMinYear() {
        String minYearInput = inputService.getLine();

        while (!inputValidationSrevice.isMinYearInputValid(minYearInput)) {
            messagePrinterSrevice.printIncorrectInputMessage();
            minYearInput = inputService.getLine();
        }

        return Integer.parseInt(minYearInput);
    }

    private int getMaxYear(int minYear) {
        String maxYearInput = inputService.getLine();

        while (!inputValidationSrevice.isMaxYearInputValid(maxYearInput, minYear)) {
            messagePrinterSrevice.printIncorrectInputMessage();
            maxYearInput = inputService.getLine();
        }

        return Integer.parseInt(maxYearInput);
    }
}
