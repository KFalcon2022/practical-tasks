package com.walking.lesson46_lambda.task3;

import com.walking.lesson46_lambda.task3.filter.*;
import com.walking.lesson46_lambda.task3.menu.Messages;
import com.walking.lesson46_lambda.task3.model.Car;
import com.walking.lesson46_lambda.task3.service.CarService;

import java.util.List;
import java.util.Scanner;

/**
 * Реализуйте Задачу из урока 21:
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson21_immutable_object">...</a>
 * с использованием списка (или другой коллекции на ваш выбор).
 * Дайте возможность искать машины по гибкому фильтру –
 * возвращайте коллекцию машин, подходящих под конкретный фильтр (можете расширить на свой вкус):
 * · Номер совпадает с введенным пользователем;
 * · Номер содержит подстроку, указанную пользователем;
 * · Цвет совпадает с указанным пользователем;
 * · Год выпуска машины находится в диапазоне, указанном пользователем.
 * <p>
 * При этом CarService должен содержать лишь один публичный метод поиска.
 * Можете использовать Predicate или собственный функциональный интерфейс.
 * <p>
 * Также реализуйте интерактивное меню в рамках консоли,
 * позволяющее производить несколько поисков в рамках одного запуска программы.
 * Предусмотрите возможность завершения программы с помощью пользовательского ввода.
 */
public class Main {
    public static List<Car> cars;

    public static void main(String[] args) {
        cars = createList();
        System.out.println(Messages.MAIN_MENU_MESSAGE);
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        while (number != 6) {
            in = new Scanner(System.in);
            switch (number) {
                case 1:
                    System.out.print(Messages.NUMBER_MESSAGE);
                    String num = in.nextLine();
                    if (num.length() == 6) {
                        filter(new FilterByNumber(num));
                    } else {
                        filter(new FilterByNumberSubstring(num));
                    }
                    break;
                case 2:
                    System.out.print(Messages.OWNER_MESSAGE);
                    filter(new FilterByOwner(in.nextLine()));
                    break;
                case 3:
                    System.out.print(Messages.BRAND_MESSAGE);
                    filter(new FilterByBrand(in.nextLine()));
                    break;
                case 4:
                    System.out.print(Messages.YEAR_FIRST_MESSAGE);
                    int start = in.nextInt();
                    System.out.print(Messages.YEAR_SECOND_MESSAGE);
                    int end = in.nextInt();
                    filter(new FilterByYear(start, end));
                    break;
                case 5:
                    System.out.print(Messages.COLOR_MESSAGE);
                    filter(new FilterByColor(in.nextLine()));
                    break;
                default:
                    System.out.println(Messages.WRONG_INPUT);
            }
            System.out.print(Messages.PROCEED_MESSAGE);
            number = in.nextInt();
        }
    }

    public static List<Car> createList() {
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

    public static void filter(Filter f) {
        print(CarService.find(cars, car -> f.filter(car)));
    }

    private static void print(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println(Messages.CARS_NOT_FOUND_MESSAGE);
        } else {
            cars.forEach(car -> System.out.println(car.toString()));
        }
    }
}
