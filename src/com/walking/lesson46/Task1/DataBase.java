package com.walking.lesson46.Task1;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataBase {
    private final String path;
    private List<Car> data = new ArrayList<>();
    private final Comparator<Car> compareByModel = (a, b) -> a.getModel().compareTo(b.getModel());
    private final Comparator<Car> compareByOwner = (a, b) -> a.getOwner().compareTo(b.getOwner());
    private final Comparator<Car> compareByYear = (a, b) -> a.getYear() - b.getYear(); // потому что int
    private final Comparator<Car> compareByNumber = (a, b) -> a.getNumber().compareTo(b.getNumber());

    public DataBase(String path) {
        this.path = path;
    }

    public void randomFill(int quantity) {
        CarFactory carFactory = new CarFactory();
        data = Stream.generate(carFactory::randomCar)
                .limit(quantity)
                .collect(Collectors.toList());
    }

    public List<Car> items() {
        return data;
    }

    public List<Car> itemsSortedByModel() {
        return data.stream()
                .sorted(compareByModel)
                //.sorted(Comparator.comparing(Car::getModel)) // а можно было и так
                .collect(Collectors.toList());
    }

    public List<Car> itemsSortedByOwner() {
        return data.stream()
                //.sorted(compareByOwner)// а можно было и так
                //.sorted(Comparator.comparing(Car::getOwner)) // а можно было и так
                .sorted((a, b) -> a.getOwner().compareTo(b.getOwner()))
                .collect(Collectors.toList());
    }

    public List<Car> itemsSortedByYearNumber() {
        return data.stream()
                .sorted(Comparator.comparing(Car::getYear)
                        .thenComparing(Comparator.comparing(Car::getNumber)))
                //.sorted(compareByYear.thenComparing(compareByNumber)) // а можно было и так
                .collect(Collectors.toList());
    }

    public boolean saveToFile() {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            for (Car car : data) {
                fos.write(carToStr(car).getBytes());
                fos.write(System.getProperty("line.separator").getBytes());
            }
            fos.flush();
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public boolean loadFromFile() {
        try (InputStreamReader fis = new InputStreamReader(new FileInputStream(path), "UTF-8")) {
            data.clear();
            int ch;

            StringBuilder sb = new StringBuilder();
            while ((ch = fis.read()) != -1) {
                if ((char) ch == System.getProperty("line.separator").charAt(0)) {
                    data.add(strToCar(sb.toString()));
                    sb = new StringBuilder();
                }
                sb.append((char) ch);
            }

            if (!sb.toString().strip().isEmpty()) {
                data.add(strToCar(sb.toString()));
            }
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    private Car strToCar(String data) {
        String[] parts = data.strip().split(":");
        String number = parts.length > 0 ? parts[0] : "";
        String owner = parts.length > 1 ? parts[1] : "";
        String model = parts.length > 2 ? parts[2] : "";
        int year = parts.length > 3 ? Integer.valueOf(parts[3]) : 2023;
        return new Car(number, owner, model, year);
    }

    private String carToStr(Car car) {
        return String.format("%s:%s:%s", car.getNumber(), car.getOwner(), car.getModel());
    }
}
