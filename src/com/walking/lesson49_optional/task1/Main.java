package com.walking.lesson49_optional.task1;

import com.walking.lesson49_optional.task1.model.Car;
import com.walking.lesson49_optional.task1.model.CarIdentifier;
import com.walking.lesson49_optional.task1.service.CarService;

import java.util.Scanner;

/**
 * Реализуйте задачу 2 урока 43:
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson43_map/task2">...</a>
 * тип возвращаемого значения в методе поиска должен быть Optional<Car>.
 * Если ничего не найдено – верните Optional.empty().
 */
public class Main {
    public static void main(String[] args) {
        CarService service = createCarsMap();

        Scanner in = new Scanner(System.in);
        System.out.print("Марка машины: ");
        String brand = in.nextLine();
        System.out.print("Номер машины: ");
        String number = in.nextLine();

        service.get(new CarIdentifier(number, brand))
                .ifPresentOrElse(c -> System.out.println(c.getInfo()),
                        () -> System.out.println("Машина не найдена."));
    }

    public static CarService createCarsMap() {
        CarService carService = new CarService();
        carService.put(new Car("Audi", "уе777к", "Печкин Ф.Б.", "синий"));
        carService.put(new Car("Ford", "ос025р", "Борисов Ю.А.", "красный"));
        carService.put(new Car("BMW", "мр666м", "Снегирь Ю.В.", "чёрный"));
        carService.put(new Car("BMW", "ра345з", "Сергеев К.Л.", "чёрный"));
        carService.put(new Car("Москвич", "кв865а", "Васильев П.Д.", "белый"));
        carService.put(new Car("Audi", "ау000ш", "Алексеев Л.Б.", "серый"));
        carService.put(new Car("Audi", "уе777к", "Печкин Ф.Б.", "жёлтый"));
        return carService;
    }
}
