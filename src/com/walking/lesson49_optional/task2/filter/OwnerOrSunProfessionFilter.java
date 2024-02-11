package com.walking.lesson49_optional.task2.filter;

import com.walking.lesson49_optional.task2.model.Car;

import java.util.function.Predicate;

public class OwnerOrSunProfessionFilter implements Predicate<Car> {
    private final String FORBIDDEN_PROFESSION="Полицейский";
    @Override
    public boolean test(Car car) {
        return car.getOwner().getProfession().equals(FORBIDDEN_PROFESSION)||
                car.getOwner().getChildren().get(0).getProfession().equals(FORBIDDEN_PROFESSION);
    }
}
