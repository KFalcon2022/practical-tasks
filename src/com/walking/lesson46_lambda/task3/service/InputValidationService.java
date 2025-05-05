package com.walking.lesson46_lambda.task3.service;

import java.time.LocalDate;

public class InputValidationService {
    private final String validYearInputRegex = "^[0-9]{4}$";
    private final Integer minYear = 1990;
    private final Integer maxYear = LocalDate.now().getYear();

    public boolean isValidYear(String input) {
        return input.matches(validYearInputRegex);
    }

    public boolean isMinYearInputValid(String firstYearInput) {
        return isMaxYearInputValid(firstYearInput, minYear);
    }

    public boolean isMaxYearInputValid(String firstYearInput, Integer minYear) {
        if (!firstYearInput.matches(validYearInputRegex)) {
            return false;
        }

        int year = Integer.parseInt(firstYearInput);
        return minYear <= year && year >= maxYear;
    }

}
