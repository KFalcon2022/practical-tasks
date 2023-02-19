/*
Поиск должен быть прекращен, если совпало хотя бы одно из условий:
·      машина новее 2021 года;
·      профессия владельца машины или его первого ребенка – «полицейский»;
·      адрес проживания содержит подстроку «Рублевское шоссе».
 */

package com.walking.lesson49_optional.Task2;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        CarService carService = new CarService(setup());

        for (String number : carService.getRegisteredNumbers()) {
            System.out.println(
                    findCarWithRequirements(
                            carService.findCar(number)
                    )
            );
        }

        /* Examples
        "ZD422B" - подходит

        "JD434H" машина новее 2021 года;
        "JD434H", "MK323V", "UU000U" профессия владельца машины полицейский
        "AD458D", "AF043L" адрес проживания содержит подстроку «Рублевское шоссе»
        "LA934F", "GW343V" профессия первого ребенка – «полицейский»;
        */
    }

    public static Optional<Car> findCarWithRequirements(Optional<Car> number) {
        return number
                .filter(c -> c.getYear() < 2021)
                .filter(c -> c.getOwner().getPosition() != Profession.POLICEMAN)
                .filter(c -> !c.getOwner().getAddress().contains("Рублевское шоссе"))
                .filter(c -> c.getOwner().getFirstChild().getPosition() != Profession.POLICEMAN);
    }

    public static Car[] setup() {
        Address a1 = new Address("Рублевское шоссе, 1");
        Address a2 = new Address("Площадь Ленина, 2");
        Address a3 = new Address("Улица Гоголя, 20");

        Person p1 = new Person("Пупа", Profession.ENGINEER, a1);
        Person p2 = new Person("Итиро", Profession.POLICEMAN, a2);
        Person p3 = new Person("Сергей", Profession.POLICEMAN, a3);
        Person p4 = new Person("Борода", Profession.UNEMPLOYED, a1);
        Person p5 = new Person("Света", Profession.ARTIST, a2);
        Person p6 = new Person("Вася", Profession.SAILOR, a3);
        Person p7 = new Person("Галя", Profession.WAITER, a2);
        Person p8 = new Person("Брюс", Profession.POLICEMAN, a3);

        p1.setMother(p5);
        p1.setFather(p2);
        p2.setMother(p7);
        p2.setFather(p6);
        p4.setFather(p8);

        Car car1 = new Car("AD458D", 2015, p1);
        Car car2 = new Car("JD434H", 2022, p2);
        Car car3 = new Car("MK323V", 1980, p3);
        Car car4 = new Car("AF043L", 2020, p4);
        Car car5 = new Car("ZD422B", 2005, p5);
        Car car6 = new Car("GW343V", 1990, p6);
        Car car7 = new Car("LA934F", 2000, p7);
        Car car8 = new Car("UU000U", 1999, p8);

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8};
    }
}
