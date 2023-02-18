package com.walking.lesson49_optional.task2;

import com.walking.lesson49_optional.task2.model.Habitation;
import com.walking.lesson49_optional.task2.model.Human;
import com.walking.lesson49_optional.task2.model.OccupationType;
import com.walking.lesson49_optional.task2.model.car.Car;
import com.walking.lesson49_optional.task2.model.car.CarIdentifier;
import com.walking.lesson49_optional.task2.service.CarService;
import com.walking.lesson49_optional.task2.service.SearchHabitationService;

import java.util.Optional;

/**
 * Реализуйте рад классов:
 * 1. Жилье, должен иметь поле «адрес»;
 * 2. Человек. Поля – «имя», «мать», «отец», «дети», «жилье», «машина», «профессия»;
 * 3. Машина. Предлагаю взять реализацию из Задачи 1 и добавить к ней поле «владелец» типа «Человек».
 * Реализуйте поиск адреса проживания первого ребенка владельца машины с заданным номером и годом выпуска.
 * Используйте реализацию поиска машины из Задачи 1. Изменять ее под требования текущей задачи – недопустимо.
 * <p>
 * Поиск должен быть прекращен, если совпало хотя бы одно из условий:
 * · машина новее 2021 года;
 * · профессия владельца машины или его первого ребенка – «полицейский»;
 * · адрес проживания содержит подстроку «Рублевское шоссе».
 * <p>
 * В таких случаях ничего не должно быть найдено.
 */
public class Main {
    private static CarService carService = new CarService(init());
    private static SearchHabitationService searchHabitationService = new SearchHabitationService();

    public static void main(String[] args) {
        testSuccessfulCase();
        testNewCarCase();
        testPolicemanParentCase();
        testIgnoredAddressCase();
        testPolicemanCase();
    }

    private static Optional<String> findAddressByCarIdentifier(CarIdentifier identifier) {
        return carService.findCar(identifier)
                .flatMap(searchHabitationService::getByCar)
                .map(Habitation::getAddress);
    }

    private static Car[] init() {
        Habitation ignoredHabitation = new Habitation("Рублевское шоссе, 1");
        Habitation availableHabitation = new Habitation("Советская, 10");

        Human human1 = new Human();
        human1.setOccupationType(OccupationType.POLICEMAN);
        human1.setHabitation(availableHabitation);

        Human human2 = new Human();
        human2.setOccupationType(OccupationType.UNEMPLOYED);
        human2.getChildren().add(human1);
        human2.setHabitation(availableHabitation);

        Human human3 = new Human();
        human3.setOccupationType(OccupationType.BUILDER);
        human3.getChildren().add(human2);
        human3.setHabitation(ignoredHabitation);

        Human human4 = new Human();
        human4.setOccupationType(OccupationType.TEACHER);
        human4.getChildren().add(human3);
        human4.setHabitation(availableHabitation);

        Human human5 = new Human();
        human5.setOccupationType(OccupationType.ENGINEER);
        human5.getChildren().add(human3);
        human5.setHabitation(availableHabitation);

        Car car1 = new Car("RR-111-RR", 2015, "yellow", true, human1);
        Car car2 = new Car("RR-222-RR", 2022, "yellow", true, human5);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true, human3);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true, human4);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true, human2);
        Car car6 = new Car("RR-666-RR", 2018, "yellow", true, human1);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true, human1);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true, human1);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true, human1);
        Car car10 = new Car("RR-000-RR", 2018, "yellow", true, human1);

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }

    private static void testSuccessfulCase() {
        findAddressByCarIdentifier(new CarIdentifier("RR-333-RR", 2017))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Address not found"));
    }

    private static void testPolicemanParentCase() {
        findAddressByCarIdentifier(new CarIdentifier("RR-111-RR", 2015))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Address not found"));
    }

    private static void testNewCarCase() {
        findAddressByCarIdentifier(new CarIdentifier("RR-222-RR", 2022))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Address not found"));
    }

    private static void testIgnoredAddressCase() {
        findAddressByCarIdentifier(new CarIdentifier("RR-444-RR", 2018))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Address not found"));
    }

    private static void testPolicemanCase() {
        findAddressByCarIdentifier(new CarIdentifier("RR-555-RR", 2018))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Address not found"));
    }
}
