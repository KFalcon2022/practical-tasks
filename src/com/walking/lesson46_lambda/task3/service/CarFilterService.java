package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.model.Car;
import com.walking.lesson46_lambda.task3.model.CarFilter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class CarFilterService {
    private final Map<String, String> filters = new HashMap<>();

    public CarFilterService(List<CarFilter> carFilters) {
        for (CarFilter carFilter : carFilters) {
            filters.put(carFilter.getName(), carFilter.getValue());
        }
    }

    public Predicate<Car> getPredicate() {
        Predicate<Car> predicate = null;
        Predicate<Car> current;

        for (String name : filters.keySet()) {
            current = choosePredicateBy(name);

            predicate = predicate == null ? current : predicate.and(current);
        }

        return predicate;
    }

    private Predicate<Car> choosePredicateBy(String name) {
        return switch (name) {
            case "color" -> getColorEqualsPredicate();

            case "number" -> getNumberEqualsPredicate();

            case "partOfNumber" -> getPartNumberContainsPredicate();

            case "yearRange" -> getYearInRangePredicate();

            default -> throw new RuntimeException("Unknown filterName" + name);
        };
    }

    private Predicate<Car> getColorEqualsPredicate() {
        return car -> car.getColor()
                         .equalsIgnoreCase(filters.get("color"));
    }

    private Predicate<Car> getNumberEqualsPredicate() {
        return car -> car.getIdentifier()
                         .getNumber()
                         .equals(filters.get("color"));
    }

    private Predicate<Car> getPartNumberContainsPredicate() {
        return car -> car.getIdentifier()
                         .getNumber()
                         .contains(filters.get("partOfNumber"));
    }

    private Predicate<Car> getYearInRangePredicate() {
        String yearRange = filters.get("yearRange");
        String[] startAndEnd = yearRange.split("-");
        int startInclusive = Integer.parseInt(startAndEnd[0]);
        int endInclusive = Integer.parseInt(startAndEnd[1]);

        return car -> car.getIdentifier()
                         .getYear() >= startInclusive && car.getIdentifier()
                                                            .getYear() <= endInclusive;
    }
}
