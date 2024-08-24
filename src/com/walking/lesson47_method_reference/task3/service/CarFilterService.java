package com.walking.lesson47_method_reference.task3.service;

import com.walking.lesson47_method_reference.task3.model.CarFilter;
import com.walking.lesson47_method_reference.task3.model.Car;

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

    public boolean isSuitAll(Car car) {
        Predicate<Car> predicate = null;
        Predicate<Car> current;

        for (String name : filters.keySet()) {
            current = choosePredicateBy(name);

            predicate = predicate == null ? current : predicate.and(current);
        }

        return predicate != null && predicate.test(car);
    }

    public boolean isEqualsColor(Car car) {
        return car.getColor()
                  .equalsIgnoreCase(filters.get("color"));
    }

    public boolean isEqualsNumber(Car car) {
        return car.getIdentifier()
                  .getNumber()
                  .equals(filters.get("number"));
    }

    public boolean isContainsPartNumber(Car car) {
        return car.getIdentifier()
                  .getNumber()
                  .contains(filters.get("partOfNumber"));
    }

    public boolean isYearInRange(Car car) {
        String yearRange = filters.get("yearRange");
        String[] startAndEnd = yearRange.split("-");
        int startInclusive = Integer.parseInt(startAndEnd[0]);
        int endInclusive = Integer.parseInt(startAndEnd[1]);

        return car.getIdentifier()
                  .getYear() >= startInclusive && car.getIdentifier()
                                                     .getYear() <= endInclusive;
    }

    private Predicate<Car> choosePredicateBy(String name) {
        return switch (name) {
            case "color" -> this::isEqualsColor;

            case "number" -> this::isEqualsNumber;

            case "partOfNumber" -> this::isContainsPartNumber;

            case "yearRange" -> this::isYearInRange;

            default -> throw new RuntimeException("Unknown filterName" + name);
        };
    }
}
