package com.walking.lesson32_files_1.task3.service;

import com.walking.lesson32_files_1.task3.exception.InvalidArgumentException;
import com.walking.lesson32_files_1.task3.model.Car;
import com.walking.lesson32_files_1.task3.model.CarColor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringJoiner;

public class CarRepository {
    private static final String CAR_SEPARATOR = "\n";
    private static final String CAR_FIELD_SEPARATOR = " ";

    private final String path;

    public CarRepository(String path) {
        this.path = path;
    }

    public void save(Car[] cars) {
        if (cars == null) {
            throw new IllegalArgumentException("Null not allowed here. Cars[] = null");
        }
        //создание пустого файла
        if (cars.length == 0) {
            saveBytes(new byte[0]);
        }

        StringBuilder allCars = new StringBuilder();

        for (Car car : cars) {
            allCars.append(getCatalogRepresentation(car));
        }

        saveBytes(allCars.toString().getBytes());
    }

    private void saveBytes(byte[] bytes) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            fileOutputStream.write(bytes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(path), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    public Car[] load() {
        String allString = new String(loadBytes());

        if (allString.length() == 0) {
            return new Car[0];
        }

        String[] allCars = allString.split(CAR_SEPARATOR);

        Car[] cars = new Car[allCars.length];

        for (int i = 0; i < allCars.length; i++) {
            cars[i] = parseCar(allCars[i]);
        }

        return cars;
    }

    private byte[] loadBytes() {
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            return fileInputStream.readAllBytes();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(path), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception, e");
        }
    }

    private Car parseCar(String carRepresentation) {
        String[] arguments = carRepresentation.split(CAR_FIELD_SEPARATOR);

        if (arguments.length != 4) {
            throw new InvalidArgumentException("Invalid number of arguments. Need 4, but was: ", String.valueOf(arguments.length));
        }

        String number = parseNumber(arguments[0]);
        int year = parseYear(arguments[1]);
        CarColor color = parseColor(arguments[2]);
        boolean hasFine = parseHasFine(arguments[3]);

        return new Car(number, year, color, hasFine);
    }

    private String parseNumber(String number) {
        if (!CarValidationService.isValidNumber(number) ) {
            throw new InvalidArgumentException("Unable parse number: ", number);
        }

        return number;
    }

    private int parseYear(String year) {
        if (!CarValidationService.isValidStringYear(year)) {
            throw new InvalidArgumentException("Unable parse year: ", year);
        }

        return Integer.parseInt(year);
    }

    private CarColor parseColor(String color) {
        color = color.toLowerCase();

        if (!CarValidationService.isValidCarColor(color) ) {
            throw new InvalidArgumentException("Unable parse color: ", color);
        }

        return switch (color) {
            case "black" -> CarColor.BLACK;
            case "white" -> CarColor.WHITE;
            case "red" -> CarColor.RED;
            case "yellow" -> CarColor.YELLOW;
            case "blue" -> CarColor.BLUE;
            case "green" -> CarColor.GREEN;
            case "orange" -> CarColor.ORANGE;
            case "indigo" -> CarColor.INDIGO;
            case "violet" -> CarColor.VIOLET;

            default -> throw new InvalidArgumentException("Invalid value of CarColor: ", color);
        };
    }

    private boolean parseHasFine(String hasFine) {
        if (!CarValidationService.isValidHasFine(hasFine) ) {
            throw new InvalidArgumentException("Unable parse hasFine: ", hasFine);
        }

        return Boolean.parseBoolean(hasFine);
    }

    public String getCatalogRepresentation(Car car) {
        StringJoiner carUnit = new StringJoiner(CAR_FIELD_SEPARATOR, "", CAR_SEPARATOR);

        carUnit.add(car.getNumber())
               .add(String.valueOf(car.getYear()))
               .add(car.getColor().getTextEn())
               .add(String.valueOf(car.hasFine()));

        return carUnit.toString();
    }
}
