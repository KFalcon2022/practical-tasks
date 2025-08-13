package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.Main;
import com.walking.lesson46_lambda.task3.domain.MainMenuItem;

public class MenuMappingSrevice {
    private final InputValidationSrevice inputValidationSrevice;

    public MenuMappingSrevice(InputValidationSrevice inputValidationSrevice) {
        this.inputValidationSrevice = inputValidationSrevice;
    }

    public MainMenuItem mapMainMenuItem(String mainMenuItem) {
        if (!inputValidationSrevice.isMainMenuItemInputValid(mainMenuItem)) {
            return MainMenuItem.INCORRECT_INPUT;
        }

        return switch (Integer.parseInt(mainMenuItem)) {
            case 1 -> MainMenuItem.SEARCH_BY_NUMBER;
            case 2 -> MainMenuItem.SEARCH_BY_NUMBER_SUBSTRING;
            case 3 -> MainMenuItem.SEARCH_BY_COLOR;
            case 4 -> MainMenuItem.SEARCH_BY_YEAR_BETWEEN;
            case 0 -> MainMenuItem.EXIT;
            default -> throw new RuntimeException("Не известный выбор меню: %s".formatted(mainMenuItem));
        };
    }
}
