package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.domain.MainMenuItem;

public class MenuMappingService {
    private final InputValidationService inputValidationService;

    public MenuMappingService(InputValidationService inputValidationService) {
        this.inputValidationService = inputValidationService;
    }

    public MainMenuItem mapMainMenuItem(String menuItemInput) {
        if (!inputValidationService.isMainMenuItemInputValid(menuItemInput)) {
            return MainMenuItem.INCORRECT_CHOICE;
        }
//            Да, современный switch-case умеет возвращать значение
        return switch (Integer.parseInt(menuItemInput)) {
            case 0 -> MainMenuItem.EXIT;
            case 1 -> MainMenuItem.SEARCH_BY_NUMBER;
            case 2 -> MainMenuItem.SEARCH_BY_NUMBER_SUBSTRING;
            case 3 -> MainMenuItem.SEARCH_BY_COLOR;
            case 4 -> MainMenuItem.SEARCH_BY_YEAR_BETWEEN;
            default -> throw new RuntimeException("Unknown main menu item input: %s".formatted(menuItemInput));
        };
    }
}
