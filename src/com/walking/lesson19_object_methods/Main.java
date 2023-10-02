package com.walking.lesson19_object_methods;

import com.walking.lesson19_object_methods.model.Car;
import com.walking.lesson19_object_methods.model.ColorList;
import com.walking.lesson19_object_methods.model.MarkList;
import com.walking.lesson19_object_methods.service.SearchCarService;

import java.util.Scanner;

/**
 * Реализуйте класс «Машина». Поля допустимо выбрать на свое усмотрение, но необходимо,
 * чтобы по ним можно было однозначно идентифицировать каждую машину.
 * Скажем, в рамках базы ГАИ.
 * <p>
 * Создайте массив машин. Реализуйте максимально эффективную проверку на вхождение машины в ваш массив.
 * Данные для проверки необходимо запрашивать с клавиатуры.
 * <p>
 * Если машина найдена — выведите ее строковое представление в консоль.
 * <p>
 * Опциональное усложнение: номер машины может быть не уникальным.
 */
public class Main {
    public static void main(String[] args) {

        SearchCarService searchCarService = new SearchCarService();

        Car[] cars = initCars();

        Car searchingCar = searchCarService.searchCar(createCar(), cars);

        System.out.println(searchingCar);
    }

    private static Car createCar() {
        String mark = null;
        String color = null;
        int yearManufacture = 0;
        int stateNumber = 0;

        System.out.println("Введите данные машины:");
        System.out.println("Марка:");

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            mark = scanner.nextLine();
        }
        System.out.println("Цвет:");
        if (scanner.hasNextLine()) {
            color = scanner.nextLine();
        }
        System.out.println("Номер:");
        if (scanner.hasNextInt()) {
            stateNumber = scanner.nextInt();
        }
        System.out.println("Год выпуска:");
        if (scanner.hasNextInt()) {
            yearManufacture = scanner.nextInt();
        }

        scanner.close();

        Car searchingCar = new Car(MarkList.setMark(mark), ColorList.setColor(color), yearManufacture, stateNumber);

        return searchingCar;
    }

    private static Car[] initCars() {
        return new Car[] {
                new Car(MarkList.AUDI, ColorList.BLACK, 2001, 674921),
                new Car(MarkList.BMW, ColorList.BLUE, 2002, 674922),
                new Car(MarkList.RENAULT, ColorList.GREEN, 2003, 674923),
                new Car(MarkList.LADA, ColorList.RED, 2004, 674924),
                new Car(MarkList.VOLVO, ColorList.GREY, 2005, 674925),
                new Car(MarkList.KIA, ColorList.WHITE, 2006, 674926),
                new Car(MarkList.MAZDA, ColorList.YELOW, 2007, 674927),
                new Car(MarkList.SUZUKI, ColorList.RED, 2008, 674928),
                new Car(MarkList.LADA, ColorList.BLUE, 2009, 674929),
        };
    }
}
