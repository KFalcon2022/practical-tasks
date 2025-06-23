package com.walking.lesson33_files_2.task1.repository;

import com.walking.lesson33_files_2.task1.model.Car;
import com.walking.lesson33_files_2.task1.service.CarParser;

import java.io.*;
import java.util.StringJoiner;

public class CarRepository {
    private static final String ELEMENT_SEPARATOR = "\n";
    private static final String FIELD_SEPARATOR = " ";

    private final File source = new File("./practical-tasks/resource/lesson33/carCatalog.txt");
    private final CarParser parser = new CarParser(ELEMENT_SEPARATOR, FIELD_SEPARATOR);

    private Car[] cars;

    public CarRepository() {
        cars = load();
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public void add(Car car) {
        //Вариант 1: FileWriter
        saveWithFileWriter(toLine(car), true);

        /*//Вариант 2: BufferedOutputStream
        saveWithBufferedOutputStream(parser.toLine(car), true);*/

        /*//Вариант 3: BufferedWriter
        saveWithBufferedWriter(parser.toLine(car), true);*/
    }

    public String toLine(Car car) {
        return new StringJoiner(FIELD_SEPARATOR, "", ELEMENT_SEPARATOR)
                .add(car.getNumber())
                .add(String.valueOf(car.getYear()))
                .add(car.getColor().getName())
                .add(String.valueOf(car.hasFine()))
                .toString();
    }

    public void rewrite() {
        StringBuilder allCars = new StringBuilder();

        for (Car car : cars) {
            allCars.append(toLine(car));
        }

        //Вариант 1: FileWriter
        saveWithFileWriter(allCars.toString(), false);

        /*//Вариант 2: BufferedOutputStream
        saveWithBufferedOutputStream(allCars.toString(), false);*/

        /*//Вариант 3: BufferedWriter
        saveWithBufferedWriter(allCars.toString(), false);*/
    }

    private void saveWithFileWriter(String data, boolean append) {
        try (FileWriter writer = new FileWriter(source, append)) {
            writer.write(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(source.getPath()), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    private void saveWithBufferedOutputStream(String data, boolean append) {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(source, append))) {
            byte[] bytes = data.getBytes();

            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(source.getPath()), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    private void saveWithBufferedWriter(String data, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(source, append))) {
            writer.write(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(source.getPath()), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    public Car[] load() {
        //Вариант 1: FileReader
        String data = loadWithFileReader();

        /*//Вариант 2: BufferedInputStream
        String data = loadWithBufferedInputStream();*/

        /*//Вариант 3: BufferedReader
        String data = loadWithBufferedReader();*/

        return parser.parseAll(data);
    }

    private String loadWithFileReader() {
        try (FileReader fileReader = new FileReader(source)) {
            int currentChar;
            StringBuilder allChars = new StringBuilder();

            while ((currentChar = fileReader.read()) != -1) {
                allChars.append((char) currentChar);
            }

            return allChars.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(source), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    private String loadWithBufferedInputStream() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(source))) {
            return new String(bufferedInputStream.readAllBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(source), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    private String loadWithBufferedReader() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            int currentChar;
            StringBuilder allChars = new StringBuilder();

            while ((currentChar = bufferedReader.read()) != -1) {
                allChars.append((char) currentChar);
            }

            return allChars.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(source), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }
}

