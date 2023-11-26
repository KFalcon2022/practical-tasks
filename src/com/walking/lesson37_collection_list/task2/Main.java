package com.walking.lesson37_collection_list.task2;

import com.walking.lesson37_collection_list.task2.service.ServiceCarCatalog;
import com.walking.lesson37_collection_list.task2.model.Car;

import java.util.List;
import java.util.Vector;

/**
 * Попробуйте реализовать собственную коллекцию, наследуясь от Collection.
 * За основу можно взять
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson28_generics1/task4">...</a>.
 * Если возникнет необходимость в имплементации методов,
 * не рассмотренных в статье - можете реализовать их как заглушки
 * (возвращая null/фиксированное значение по умолчанию/бросая исключение).
 */


public class Main {
    public static void main(String[] args) {
        List<Car> carCatalog = new Vector<>() {
        };
        carCatalog.add(new Car("Toyota", "Crown", "fgh345", "white", "8974jdfo98uyh39", true));
        carCatalog.add(new Car("Honda", "Vezel", "ghj4354", "white", "hfgh345345", true));
        carCatalog.add(new Car("Toyota", "Supra", "67545", "black", "56858thk6", true));
        carCatalog.add(new Car("Nissan", "Cedric", "767fgh", "gold", "907878ukyh", false));
        carCatalog.add(new Car("Nissan", "Laurel", "87654", "lgks", "y875gj", true));
        carCatalog.add(new Car("Toyota", "Mark_X", "6347hf", "white", "7o7l687kukj", false));

        ServiceCarCatalog service = new ServiceCarCatalog(carCatalog);
        service.printList();
        System.out.println("____________________________________________");
        service.removeCar("87654");
        service.printList();

    }
}
