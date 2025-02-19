package com.walking.lesson49_optional.task2.service;

import com.walking.lesson49_optional.task2.model.Car.Car;
import com.walking.lesson49_optional.task2.model.Home;
import com.walking.lesson49_optional.task2.model.Human;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class SearchConditionService {
    public Optional<Home> searchConditionResult(Car car) {
        return Optional.ofNullable(car)
                .filter(c -> c.getIdenty().getYear() <= 2021)
                .map(Car::getOwner)
                .filter(father -> !father.getProfession().equals("полицейский"))
                .map(Human::getChildren)
                .filter(Predicate.not(Collection::isEmpty))
                .map(children -> children.get(0))
                .filter(child -> !child.getProfession().equals("полицейский"))
                .map(Human::getHome)
                .filter(home -> home.getAdress().contains("Рублевское шоссе"));
    }
}
