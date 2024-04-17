package com.walking.lesson33_files_2.task1.service;

import com.walking.lesson33_files_2.task1.exception.InvalidArgumentException;
import com.walking.lesson33_files_2.task1.model.CarColor;

public class CarValidationService {
    private static final String VALID_NUMBERS = "^[A-Za-z]\\d{3}[A-Za-z]{2}$";
    private static final String VALID_YEARS = "^19[56789]\\d$|^2[01]\\d{2}$";

    public static void validateCarArguments(String number, int year, CarColor color) {
        if (!isValidNumber(number)) {
            throw new InvalidArgumentException("Unable create Car. Invalid value of number: ", number);
        }

        if (!isValidYear(year)) {
            throw new InvalidArgumentException("Unable create Car. Invalid value of year: ", String.valueOf(year));
        }

        if (color == null) {
            throw new IllegalArgumentException("Null not allowed here. Color = null");
        }
    }

    public static boolean isValidNumber(String number) {
        if (number == null) {
            throw new IllegalArgumentException("Null not allowed here. Number = null");
        }

        return number.matches(VALID_NUMBERS);
    }

    public static boolean isValidYear(int year) {
        return year >= 1950
                &&
                year <= 2199;
    }

    public static boolean isValidStringYear(String year) {
        if (year == null) {
            throw new IllegalArgumentException("Null not allowed here. Year = null");
        }

        return year.matches(VALID_YEARS);
    }

    public static boolean isValidCarColor(String color) {
        if (color == null) {
            throw new IllegalArgumentException("Null not allowed here. Color = null");
        }

        return switch (color) {
            case "black",
                 "white",
                 "red",
                 "yellow",
                 "blue",
                 "green",
                 "orange",
                 "indigo",
                 "violet" -> true;

            default -> false;
        };
    }

    public static boolean isValidHasFine(String hasFine) {
        return hasFine.equalsIgnoreCase("true")
                || hasFine.equalsIgnoreCase("false");
    }
}
