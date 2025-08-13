package com.walking.lesson46_lambda.task3;


import com.walking.lesson46_lambda.task3.model.Car;
import com.walking.lesson46_lambda.task3.model.ColorType;
import com.walking.lesson46_lambda.task3.model.MarkType;
import com.walking.lesson46_lambda.task3.service.*;

import java.util.HashSet;
import java.util.Set;

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
        InputValidationSrevice inputValidationSrevice = new InputValidationSrevice();
        MenuMappingSrevice menuMappingSrevice = new MenuMappingSrevice(inputValidationSrevice);
        MessagePrinterSrevice messagePrinterSrevice = new MessagePrinterSrevice();

        MenuService menuService = new MenuService(carService,
                inputService,
                inputValidationSrevice,
                menuMappingSrevice,
                messagePrinterSrevice);

        try {
            menuService.processMainMenu();
        } finally {
            inputService.destroy();
        }
    }

    private static HashSet<Car> initCars() {
        HashSet<Car> cars = new HashSet<>();

        cars.add(new Car(MarkType.AUDI, ColorType.BLACK, 2001, 674921));
        cars.add(new Car(MarkType.BMW, ColorType.BLUE, 2002, 674922));
        cars.add(new Car(MarkType.RENAULT, ColorType.GREEN, 2003, 674923));
        cars.add(new Car(MarkType.LADA, ColorType.RED, 2004, 674924));
        cars.add(new Car(MarkType.VOLVO, ColorType.GREY, 2005, 674925));
        cars.add(new Car(MarkType.KIA, ColorType.WHITE, 2006, 674926));
        cars.add(new Car(MarkType.MAZDA, ColorType.YELOW, 2007, 674927));
        cars.add(new Car(MarkType.SUZUKI, ColorType.RED, 2008, 674928));
        cars.add(new Car(MarkType.LADA, ColorType.BLUE, 2009, 674929));

        return cars;
    }
}
