package com.walking.lesson49_optional.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import com.walking.lesson49_optional.task2.service.CarService;
import com.walking.lesson49_optional.task2.model.Car;
import com.walking.lesson49_optional.task2.model.Human;
import com.walking.lesson49_optional.task2.model.Specification;

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
        CarService carService=new CarService(initCars());
        Car requestedCar=requestCar();
        System.out.println(carService.findCar(requestedCar)
        .filter(car->car.specification.getYear()<=2021)
        .map(Car::getOwner)
        .filter(owner->!owner.profession.equals("полицейский"))
        .map(owner->owner.children.getFirst())
        .filter(child->!child.profession.equals("полицейский"))
        .filter(child->!child.house.address.contains("Рублевское шоссе"))
        .map(child->child.house.address)
        .orElse("Not found")
        );
    }

        private static Car requestCar() {
        Scanner sc=new Scanner(System.in);
        String gosNumber=getValue("Insert number:", sc);;
        String engineVin=getValue("Insert engine vin:", sc);
        // String brand=getValue("Insert brand:", sc);
        // String model=getValue("Insert model", sc);
        // int year=Integer.parseInt(getValue("Insert year", sc));
        // String color=getValue("Insert color:", sc);
        // Specification sp=new Specification(brand, model,year);
        sc.close();
        return new Car(gosNumber, engineVin, null, null, null);
    }

    private static String getValue(String message, Scanner sc){
        System.out.println(message);
        return sc.nextLine();
    }
    private static Collection<Car> initCars(){
        ArrayList<Car> list=new ArrayList<>();
        Specification HyundaiPorter=new Specification("Hyundai", "Porter", 1999);
        Specification NissanPrimera=new Specification("Nissan", "Primera", 2005);
        Specification VolkswagenGolf=new Specification("Volkswagen", "Golf", 2022);

        Human human=new Human("Москва", "полицейский", "Пётр");
        human.children.add(new Human("Москва", "инженер", "Василий"));
        list.add(new Car("м785ун", "x7mxkn7fp6m004121", HyundaiPorter, "White", human));
        human.car=list.getLast();

        human=new Human("Москва", "инженер", "Пётр");
        human.children.add(new Human("Москва", "полицейский", "Василий"));
        list.add(new Car("м786ун", "x7mxkn7fp6m004122", HyundaiPorter, "Black",human));
        human.car=list.getLast();

        human=new Human("Москва", "инженер", "Пётр");
        human.children.add(new Human("Рублевское шоссе", "инженер", "Василий"));
        list.add(new Car("м787ун", "x7mxkn7fp6m004123", HyundaiPorter, "Grey",human));
        human.car=list.getLast();

        human=new Human("Рублевское шоссе", "инженер", "Пётр");
        human.children.add(new Human("Москва", "инженер", "Василий"));
        list.add(new Car("у462ун", "sjnbaap10u0107597", NissanPrimera, "Blue",human));
        human.car=list.getLast();

        human=new Human("Пермь", "слесарь", "Евгений");
        human.children.add(new Human("Рязань", "Маркетолог", "Светлана"));
        list.add(new Car("у463ун", "sjnbaap10u0107598", NissanPrimera, "Blue",human));
        human.car=list.getLast();

        human=new Human("Пенза", "строитель", "Виктор");
        human.children.add(new Human("Красноярск", "Продавец", "Павел"));
        list.add(new Car("у464ун", "sjnbaap10u0107599", NissanPrimera, "Green",human));
        human.car=list.getLast();

        human=new Human("Анапа", "строитель", "Григорий");
        human.children.add(new Human("Сочи", "Официант", "Анна"));
        list.add(new Car("м131вв", "wvwzzz1k26w024582", VolkswagenGolf, "Grey",human));
        human.car=list.getLast();

        human=new Human("Кисловодск", "крановщик", "Сергей");
        human.children.add(new Human("Волгоград", "Риелтор", "Олег"));
        list.add(new Car("м231вв", "wvwzzz1k26w024583", VolkswagenGolf, "Grey",human));
        human.car=list.getLast();

        return list;
    }
}
