package com.walking.lesson46_lambda.task3.service;

import java.time.LocalDate;

public class InputValidationSrevice {
    private static final String MAIN_MENU_VALIDATION_REGEX = "^[0-4]$";
    private static final String YEAR_VALIDATION_REGEX = "^[0-9]{4}$";
    private static final int MIN_AVAILABLE_YEAR = 1900;
    private static final int MAX_AVAILABLE_YEAR = LocalDate.now().getYear();

    public boolean isMainMenuItemInputValid(String mainMenuItem) {
        return mainMenuItem.matches(MAIN_MENU_VALIDATION_REGEX);
    }

    public boolean isMinYearInputValid(String minYearInput) {
        return isMaxYearInputValid(minYearInput, MIN_AVAILABLE_YEAR);
    }

    public boolean isMaxYearInputValid(String maxYearInput, int minYearInput) {
        if (!maxYearInput.matches(YEAR_VALIDATION_REGEX)) {
            return false;
        }

        int year = Integer.parseInt(maxYearInput);
        return minYearInput <= year && year <= MAX_AVAILABLE_YEAR;
    }
}
