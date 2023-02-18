package com.walking.lesson49_optional.task2.service;

import com.walking.lesson49_optional.task2.model.Habitation;
import com.walking.lesson49_optional.task2.model.Human;
import com.walking.lesson49_optional.task2.model.OccupationType;
import com.walking.lesson49_optional.task2.model.car.Car;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class SearchHabitationService {
    public Optional<Habitation> getByCar(Car car) {
        return Optional.ofNullable(car)
                .filter(c -> c.getIdentifier().getYear() <= 2021)
                .map(Car::getOwner)
                .filter(father -> father.getOccupationType() != OccupationType.POLICEMAN)
                .map(Human::getChildren)
                .filter(Predicate.not(Collection::isEmpty))
                .map(children -> children.get(0))
                .filter(child -> child.getOccupationType() != OccupationType.POLICEMAN)
                .map(Human::getHabitation)
                .filter(habitation -> !habitation.getAddress().toLowerCase().contains("рублевское шоссе"));
    }
}
