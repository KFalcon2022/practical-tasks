package com.walking.lesson33_files_2.task1.service;

import com.walking.lesson33_files_2.task1.exception.RegexValidationException;
import com.walking.lesson33_files_2.task1.exception.UnableParsingException;
import com.walking.lesson33_files_2.task1.model.Car;
import com.walking.lesson33_files_2.task1.model.Color;
import com.walking.lesson33_files_2.task1.repository.CarRepository;

public class CarParser {
    private static final String VALID_NUMBERS = "^[A-Za-z]\\d{3}[A-Za-z]{2}$";
    private static final String VALID_YEARS = "^19[56789]\\d$|^2[01]\\d{2}$";

    private final String input;

    public CarParser(String input) {
        this.input = input;
    }

    public Car[] parseAllCars() {
        if (input.length() == 0) {
            return new Car[0];
        }

        String[] carCandidates = input.split(CarRepository.CAR_SEPARATOR);

        Car[] cars = new Car[carCandidates.length];

        for (int i = 0; i < carCandidates.length; i++) {
            cars[i] = parseSingleCar(carCandidates[i]);
        }

        return cars;
    }

    public Car parseSingleCar(String carCandidate) {
        String[] fields = carCandidate.split(CarRepository.CAR_FIELD_SEPARATOR);

        if (fields.length != 4) {
            throw new IllegalArgumentException("Invalid number of fields. Need 4, but was: " + fields.length);
        }

        String number = parseNumber(fields[0]);
        int year = parseYear(fields[1]);
        Color color = parseColor(fields[2]);
        boolean fine = parseFine(fields[3]);

        return new Car(number, year, color, fine);
    }

    private String parseNumber(String number) {
        if (!number.matches(VALID_NUMBERS)) {
            throw new RegexValidationException("Unable parse number:", number, VALID_NUMBERS);
        }

        return number;
    }

    private int parseYear(String year) {
        if (!year.matches(VALID_YEARS)) {
            throw new RegexValidationException("Unable parse year:", year, VALID_YEARS);
        }

        return Integer.parseInt(year);
    }

    private Color parseColor(String color) {
        return Color.parseColorByName(color.toLowerCase());
    }

    private boolean parseFine(String fine) {
        if (!"true".equalsIgnoreCase(fine) && !"false".equalsIgnoreCase(fine)) {
            throw new UnableParsingException("Unable parse boolean value:", fine);
        }

        return Boolean.parseBoolean(fine);
    }
}
