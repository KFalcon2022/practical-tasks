package com.walking.lesson45_lyambda.task3.service;

import com.walking.lesson45_lyambda.task3.model.Car;
import com.walking.lesson45_lyambda.task3.model.MyFunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CarService {
    private final List<Car> cars;

    public CarService(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findCars(String query) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (parseQuery(query).test(car)) {
                result.add(car);
            }
        }
//        return cars.stream().filter(parseQuery(query)).collect(Collectors.toList());

        return result;
    }

    private Predicate<Car> parseQuery(String query) {
        Predicate<Car> result = o -> true;

        String[] filters = query.split(";");

        for (String filter : filters) {
            String[] params = filter.trim().split(" ");
            if (params.length != 3) {
                throw new IllegalArgumentException("Wrong query");
            }
            switch (params[0]) {
                case "number" -> {
                    switch (params[1]) {
                        case "contains" -> result = result.and(o -> o.getIdentifier().getNumber().contains(params[2]));
                        case "=" -> result = result.and(o -> o.getIdentifier().getNumber().equals(params[2]));
                        default -> throw new IllegalArgumentException("Wrong query");
                    }
                }
                case "year" -> {
                    switch (params[1]) {
                        case "=" ->
                                result = result.and(o -> o.getIdentifier().getYear() == Integer.parseInt(params[2]));
                        case ">" -> result = result.and(o -> o.getIdentifier().getYear() < Integer.parseInt(params[2]));
                        case "<" -> result = result.and(o -> o.getIdentifier().getYear() > Integer.parseInt(params[2]));
                        case "between" -> {
                            String[] years = params[2].split("-");
                            int begin = Integer.parseInt(years[0]);
                            int end = Integer.parseInt(years[1]);
                            if (begin > end || begin == end) {
                                throw new IllegalArgumentException("Wrong query");
                            }
                            result = result.and(o -> {
                                int year = o.getIdentifier().getYear();
                                return year > begin && year < end;
                            });
                        }
                        default -> throw new IllegalArgumentException("Wrong query");
                    }
                }
                case "color" -> {
                    switch (params[1]) {
                        case "=" -> result = result.and(o -> o.getColor().equals(params[2]));
                        case "contains" -> result = result.and(o -> o.getColor().contains(params[2]));
                        default -> throw new IllegalArgumentException("Wrong query");
                    }
                }
                case "actualTechnicalInspection" -> {
                    switch (params[1]) {
                        case "=" ->
                                result = result.and(o -> o.isActualTechnicalInspection() == Boolean.parseBoolean(params[2]));
                        default -> throw new IllegalArgumentException("Wrong query");
                    }
                }
                default -> throw new IllegalArgumentException("Wrong query");
            }
        }

        return result;
    }

    //Ну что-то такое...
    public List<Car> findCarsV2(String query) {
        List<Car> result = new ArrayList<>();
        String[] params = query.trim().split(" ");

        if (params.length != 3) {
            throw new IllegalArgumentException("Wrong query");
        }

        String filter = params[2];

        for (Car car : cars) {
            if (parseQueryV2(params).test(car, filter)) {
                result.add(car);
            }
        }

        return result;
    }

    private MyFunctionalInterface<Car, String> parseQueryV2(String[] params) {

        switch (params[0]) {
            case "number" -> {
                switch (params[1]) {
                    case "contains" -> {
                        return this::numberContains;
                    }
                    case "=" -> {
                        return this::numberIsEqual;
                    }
                }
            }
        }

        throw new IllegalArgumentException("Wrong query");
    }

    private Boolean numberContains(Car car, String filter) {
        return car.getIdentifier().getNumber().contains(filter);
    }

    private Boolean numberIsEqual(Car car, String filter) {
        return car.getIdentifier().getNumber().equals(filter);
    }
}

