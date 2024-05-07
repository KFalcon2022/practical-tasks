package com.walking.lesson33_files_2.task1.service;

import com.walking.lesson33_files_2.task1.exception.UnableParsingException;
import com.walking.lesson33_files_2.task1.model.Car;
import com.walking.lesson33_files_2.task1.model.Color;

import java.util.StringJoiner;

public class CarParser {
    private static final String ELEMENT_SEPARATOR = "\n";
    private static final String FIELD_SEPARATOR = " ";

    public String toLine(Car car) {
        return new StringJoiner(FIELD_SEPARATOR, "", ELEMENT_SEPARATOR)
                .add(car.getNumber())
                .add(String.valueOf(car.getYear()))
                .add(car.getColor().getName())
                .add(String.valueOf(car.hasFine()))
                .toString();
    }

    public Car[] parseAll(String allCandidates) {
        if (allCandidates.length() == 0) {
            return new Car[0];
        }

        String[] singleCandidates = allCandidates.split(ELEMENT_SEPARATOR);

        Car[] elements = new Car[singleCandidates.length];

        for (int i = 0; i < singleCandidates.length; i++) {
            elements[i] = parseSingle(singleCandidates[i]);
        }

        return elements;
    }

    public Car parseSingle(String singleCandidate) {
        String[] fields = singleCandidate.split(FIELD_SEPARATOR);

        if (fields.length != 4) {
            throw new UnableParsingException("Unable parse single element: ", singleCandidate);
        }

        String number = parseNumber(fields[0]);
        int year = parseYear(fields[1]);
        Color color = parseColor(fields[2]);
        boolean fine = parseFine(fields[3]);

        return new Car(number, year, color, fine);
    }

    private String parseNumber(String number) {
        return number;
    }

    private int parseYear(String year) {
        return Integer.parseInt(year);
    }

    private Color parseColor(String color) {
        return Color.parseColorByName(color.toLowerCase());
    }

    private boolean parseFine(String fine) {
        if (!"true".equalsIgnoreCase(fine) && !"false".equalsIgnoreCase(fine)) {
            throw new UnableParsingException("Unable parse boolean value: ", fine);
        }

        return Boolean.parseBoolean(fine);
    }
}
