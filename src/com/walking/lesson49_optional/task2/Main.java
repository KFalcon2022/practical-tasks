package com.walking.lesson49_optional.task2;

import com.walking.lesson49_optional.task2.model.Car;
import com.walking.lesson49_optional.task2.model.CarIdentifier;
import com.walking.lesson49_optional.task2.model.Home;
import com.walking.lesson49_optional.task2.model.Person;
import com.walking.lesson49_optional.task2.service.CarService;

import java.util.ArrayList;
import java.util.List;
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
    public static void main(String[] args) {
        Home testHome = new Home("ADDRESS");
        Car testCar = new Car(new CarIdentifier("NUMBER", 2000), null, "red", true);
        Person testCarOwner = new Person("OWNER", null, null, new ArrayList<>(), testHome, testCar, "fireman");
        testCar.setOwner(testCarOwner);
        Person testCarOwnerChild = new Person("CHILD", null, testCarOwner, null, testHome, null, "fireman");
        testCarOwner.addChild(testCarOwnerChild);

        CarService carService = new CarService(new Car[]{testCar});

        Optional<String> foundAddress = carService.findCar(testCar)
                                                  .filter(car -> car.getIdentifier()
                                                                    .getYear() <= 2021)
                                                  .map(Car::getOwner)
                                                  .filter(person -> !person.getProfession()
                                                                           .equals("policeman"))
                                                  .map(Person::getChildren)
                                                  .filter(list -> !list.isEmpty())
                                                  .map(List::getFirst)
                                                  .filter(person -> !person.getProfession()
                                                                           .equals("policeman"))
                                                  .map(Person::getHome)
                                                  .map(Home::getAddress)
                                                  .filter(address -> !address.contains("Рублевское шоссе"));

        String address = foundAddress.map("Найден адрес:\n%s"::formatted)
                                     .orElse("Адресс не найден");

        System.out.println(address);
    }
}
