package com.walking.lesson46_lambda.task3;

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
    public static void main(String[] args) {
        List<Car> cars = createList();
        System.out.println("Введите номер действия: 1 - поиск по номеру, 2 - поиск по владельцу, 3 - поиск по марке, " +
                "4 - поиск по году выпуска, 5 - поиск по цвету, 6 - завершить программу");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        while (number != 6) {
            in = new Scanner(System.in);
            switch (number) {
                case 1:
                    System.out.print("Введите номер машины или его часть: ");
                    String num = in.nextLine();
                    List<Car> foundCars = filterByNumber(cars, num);
                    if (foundCars.isEmpty()) {
                        foundCars = filterByNumberSubstring(cars, num);
                    }
                    print(foundCars);
                    break;
                case 2:
                    System.out.print("Введите имя владельца: ");
                    String owner = in.nextLine();
                    print(filterByOwner(cars, owner));
                    break;
                case 3:
                    System.out.print("Введите марку: ");
                    print(filterByBrand(cars, in.nextLine()));
                    break;
                case 4:
                    System.out.print("Введите начало диапозона: ");
                    int start = in.nextInt();
                    System.out.print("Введите конец диапозона: ");
                    int end = in.nextInt();
                    print(filterByYear(cars, start, end));
                    break;
                case 5:
                    System.out.print("Введите цвет: ");
                    print(filterByColor(cars, in.nextLine()));
                    break;
            }
            System.out.print("Введите номер действия: ");
            number = in.nextInt();
        }
    }

    public static List<Car> filterByNumber(List<Car> cars, String number) {
        return new CarService().find(cars, car -> car.getIdentifier().getNumber().equals(number));
    }

    public static List<Car> filterByNumberSubstring(List<Car> cars, String substring) {
        String regex = "^.*" + substring + ".*$";
        return new CarService().find(cars, car -> car.getIdentifier().getNumber().matches(regex));
    }

    public static List<Car> filterByColor(List<Car> cars, String color) {
        return new CarService().find(cars, car -> car.getColor().equals(color));
    }

    public static List<Car> filterByOwner(List<Car> cars, String owner) {
        return new CarService().find(cars, car -> car.getOwner().equals(owner));
    }

    public static List<Car> filterByBrand(List<Car> cars, String brand) {
        return new CarService().find(cars, car -> car.getIdentifier().getBrand().equals(brand));
    }

    public static List<Car> filterByYear(List<Car> cars, int start, int end) {
        return new CarService().find(cars, car -> car.getReleaseYear() >= start && car.getReleaseYear() <= end);
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

    public static void print(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("Машины, соответствующие условию поиска, не найдены.");
        } else {
            cars.forEach(car -> System.out.println(car.toString()));
        }
    }
}
