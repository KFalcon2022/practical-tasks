package com.walking.lesson33_files_2.task1.service;

import com.walking.lesson33_files_2.task1.exception.InvalidArgumentException;
import com.walking.lesson33_files_2.task1.model.Car;
import com.walking.lesson33_files_2.task1.model.CarColor;
import com.walking.lesson33_files_2.task1.model.IOStreamType;

import java.io.*;
import java.util.StringJoiner;

public class CarRepository {
    private static final String CAR_SEPARATOR = "\n";
    private static final String CAR_FIELD_SEPARATOR = " ";

    private final File carCatalog;

    public CarRepository(File carCatalog) {
        if (carCatalog == null) {
            throw new IllegalArgumentException("Null not allowed here. File = null");
        }

        this.carCatalog = carCatalog;
    }

    public void save(Car[] cars, IOStreamType ioStreamType) {
        if (cars == null) {
            throw new IllegalArgumentException("Null not allowed here. Cars[] = null");
        }

        if (ioStreamType == null) {
            throw new IllegalArgumentException("Null not allowed here. IOStreamType = null");
        }

        //создание пустого файла?

        switch (ioStreamType) {
            case BUFFERED_OUTPUT_STREAM -> saveCarsWithBufferedOutputStream(cars);
            case FILE_WRITER -> saveCarsWithFileWriter(cars);
            case BUFFERED_WRITER -> saveCarsWithBufferedWriter(cars);

            default ->
                    throw new IllegalArgumentException("IOStreamType value not allowed here. IOStreamType = " + ioStreamType);
        }
    }

    private void saveCarsWithFileWriter(Car[] cars) {
        try (FileWriter carFileWriter = new FileWriter(carCatalog)) {
            for (Car car : cars) {
                carFileWriter.write(getCatalogRepresentation(car));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(carCatalog.getPath()), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    private void saveCarsWithBufferedOutputStream(Car[] cars) {
        try (BufferedOutputStream carBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(carCatalog))) {
            byte[] bytes;

            for (Car car : cars) {
                bytes = getCatalogRepresentation(car).getBytes();

                carBufferedOutputStream.write(bytes);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(carCatalog.getPath()), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    private void saveCarsWithBufferedWriter(Car[] cars) {
        try (BufferedWriter carBufferedWriter = new BufferedWriter(new FileWriter(carCatalog))) {
            for (Car car : cars) {
                carBufferedWriter.write(getCatalogRepresentation(car));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(carCatalog.getPath()), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    public Car[] load(IOStreamType ioStreamType) {
        if (ioStreamType == null) {
            throw new IllegalArgumentException("Null not allowed here. IOStreamType = null");
        }

        return switch (ioStreamType) {
            case BUFFERED_INPUT_STREAM -> loadCarsWithBufferedInputStream();
            case FILE_READER -> loadCarsWithFileReader();
            case BUFFERED_READER -> loadCarsWithBufferedReader();

            default ->
                    throw new IllegalArgumentException("IOStreamType value not allowed here. IOStreamType = " + ioStreamType);
        };
    }

    private Car[] loadCarsWithFileReader() {
        try (FileReader carFileReader = new FileReader(carCatalog)) {
            int currentChar;
            StringBuilder carCandidates = new StringBuilder();

            while ((currentChar = carFileReader.read()) != -1) {
                carCandidates.append((char) currentChar);
            }

            return parseCars(carCandidates.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(carCatalog), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception, e");
        }
    }

    private Car[] loadCarsWithBufferedInputStream() {
        try (BufferedInputStream carBufferedInputStream = new BufferedInputStream(new FileInputStream(carCatalog))) {
            String carCandidates = new String(carBufferedInputStream.readAllBytes());

            return parseCars(carCandidates);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(carCatalog), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception, e");
        }
    }

    private Car[] loadCarsWithBufferedReader() {
        try (BufferedReader carBufferedReader = new BufferedReader(new FileReader(carCatalog))) {
            String currentLine;
            StringBuilder carCandidates = new StringBuilder();

            while ((currentLine = carBufferedReader.readLine()) != null) {
                carCandidates.append(currentLine);
                /* метод readLine() не читает символы перевода строки,
                   но текущая реализация использует их для разделения данных разных объектов
                   поэтому добавляем их отдельно */
                carCandidates.append('\n');
            }

            return parseCars(carCandidates.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(carCatalog), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception, e");
        }
    }

    private Car[] parseCars(String allCars) {
        /* если сохраняли пустой массив, возвращаем такой же */
        if (allCars.length() == 0) {
            return new Car[0];
        }

        String[] carCandidates = allCars.split(CAR_SEPARATOR);

        Car[] cars = new Car[carCandidates.length];

        for (int i = 0; i < carCandidates.length; i++) {
            cars[i] = parseCar(carCandidates[i]);
        }

        return cars;
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
        if (!CarValidationService.isValidNumber(number)) {
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

        if (!CarValidationService.isValidCarColor(color)) {
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
        if (!CarValidationService.isValidHasFine(hasFine)) {
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
