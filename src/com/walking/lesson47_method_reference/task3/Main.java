package com.walking.lesson47_method_reference.task3;

import com.walking.lesson47_method_reference.task3.filter.Filter;
import com.walking.lesson47_method_reference.task3.menu.Messages;
import com.walking.lesson47_method_reference.task3.model.Car;
import com.walking.lesson47_method_reference.task3.service.CarService;
import com.walking.lesson47_method_reference.task3.service.FilterService;

import java.util.List;
import java.util.Scanner;

/**
 * Реализуйте Задачу 3 из урока 46,
 * описав все реализуемые фильтры через method reference’ы.
 * Рекомендую вынести функциональность формирования фильтров в отдельный сервис,
 * если это не было сделано ранее.
 */
public class Main {
    public static List<Car> cars;

    public static void main(String[] args) {
        cars = createList();
        System.out.println(Messages.MAIN_MENU_MESSAGE);
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        while (number != 6) {
            try {
                filter(FilterService.get(number));
                System.out.print(Messages.PROCEED_MESSAGE);
            } catch (RuntimeException e) {
                System.out.print(e.getMessage());
            }
            number = in.nextInt();
        }
    }

    private static List<Car> createList() {
        return List.of(
                new Car("Audi", "Печкин Ф.Б.", "уе777к", "красный", 1995),
                new Car("BMW", "Борисов Ю.А.", "ос025р", "чёрный", 2003),
                new Car("Ford", "Снегирь Ю.В.", "мр666м", "белый", 2005),
                new Car("Bentley", "Белова Д.М.", "ра345з", "чёрный", 2000),
                new Car("Ferrari", "Сергеев К.Л.", "уе999з", "чёрный", 2020),
                new Car("Москвич", "Попов А.Д.", "ар832с", "синий", 1978),
                new Car("Audi", "Васильев П.Д.", "кв865а", "белый", 1980),
                new Car("BMW", "Лебедев А.Ю.", "ау000ш", "синий", 2010),
                new Car("Москвич", "Алексеев Л.Б.", "гн123г", "жёлтый", 1973));
    }

    private static void filter(Filter f) {
        print(CarService.find(cars, f::filter));
    }

    private static void print(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println(Messages.CARS_NOT_FOUND_MESSAGE);
        } else {
            cars.forEach(car -> System.out.println(car.toString()));
        }
    }
}
