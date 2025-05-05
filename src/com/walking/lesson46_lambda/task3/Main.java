package com.walking.lesson46_lambda.task3;

import com.walking.lesson46_lambda.task3.model.Car;
import com.walking.lesson46_lambda.task3.service.*;

import java.util.ArrayList;
import java.util.List;

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
        CarService carService = new CarService(initCars());
        InputService inputService = new InputService();
        InputValidationService inputValidationService = new InputValidationService();
        PrintMessageService printMessageService = new PrintMessageService();
        LauncherService launcherService = new LauncherService(inputService, inputValidationService, carService, printMessageService);

        try {
            launcherService.start();
        } finally {
            inputService.close();
        }
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("BMW", "Black", "1234", 2007));
        cars.add(new Car("Toyota", "White", "1234", 1998));
        cars.add(new Car("Toyota", "Red", "0890", 2011));
        cars.add(new Car("Toyota", "Black", "0890", 2011));

        return cars;
    }
}
