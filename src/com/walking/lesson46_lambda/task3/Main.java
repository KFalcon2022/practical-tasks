package com.walking.lesson46_lambda.task3;

import com.walking.lesson46_lambda.task3.model.Car;
import com.walking.lesson46_lambda.task3.model.CarIdentifier;
import com.walking.lesson46_lambda.task3.service.CarService;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

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
    private final static String cancel = "Нет";
    public static void main(String[] args) {
        CarService carService = new CarService(initCars());

        Scanner scanner = new Scanner(System.in);

        boolean isExits = false;

        List<Car> foundCar;

        while (true) {
            System.out.print("""
                    Введите название фильтра который хотите использовать
                    1 - Введите полный номер
                    2 - Введите часть номера
                    3 - Введите цвет машины
                    4 - Введите диапазон года выпуска через дефис
                    5 - Чтобы выйти
                    """);

            String stringFilterNumber = scanner.nextLine();


            int filterNumber = -1;

            if (stringFilterNumber.matches("\\d+")) {
                filterNumber = Integer.parseInt(stringFilterNumber);
            }

            if (filterNumber == 5) {
                break;
            }

            if (filterNumber < 1 || filterNumber > 5) {
                System.out.println("Значение введено неверно, повторите ввод");
                continue;
            }

            System.out.println("Введите значение");
            String filter = scanner.nextLine();

            foundCar = carService.findCar(filterCar(filterNumber, filter));

            System.out.println(foundCar + "\n");

            System.out.println("Хотите продолжить? (Напишите - \"Нет\" если хотите выйти");
            String accept = scanner.nextLine();

            if (accept.equals(cancel)) {
                break;
            }
        }

        scanner.close();
    }


    private static Predicate<Car> filterCar(int filterNumber, String filter) {
//        Неудачный шаг со сканером, повторно использовать метод createCar() мы не сможем.
//        Спишем на условности


            switch (filterNumber) {
                case 1:
                    return x -> x.getIdentifier().getNumber().equals(filter);

                case 2:
                    return x -> x.getIdentifier().getNumber().contains(filter);

                case 3: return x -> x.getColor().equals(filter);

                case 4: {
                    String[] years = filter.split("-");
                    String filter1 = years[0];
                    String filter2 = years[1];

                    return x -> x.getIdentifier().getYear() >= Integer.parseInt(filter1) && x.getIdentifier().getYear() <= Integer.parseInt(filter2);
                }

            }

            return null;
        }

    private static List<Car> initCars() {
        return List.of(
                new Car("RR-111-RR", 2015, "yellow", true),
                new Car("RR-222-RR", 2016, "yellow", true),
                new Car("RR-333-RR", 2017, "yellow", true),
                new Car("RR-444-RR", 2018, "yellow", true),
                new Car("RR-555-RR", 2018, "yellow", true),
                new Car("RR-666-RR", 2018, "yellow", true),
                new Car("RR-777-RR", 2018, "yellow", true),
                new Car("RR-888-RR", 2018, "yellow", true),
                new Car("RR-999-RR", 2018, "yellow", true),
                new Car("RR-000-RR", 2018, "yellow", true));
    }
}

