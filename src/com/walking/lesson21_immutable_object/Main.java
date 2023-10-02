package com.walking.lesson21_immutable_object;



import com.walking.lesson21_immutable_object.model.Car;
import com.walking.lesson21_immutable_object.model.ColorList;
import com.walking.lesson21_immutable_object.model.IdentityCar;
import com.walking.lesson21_immutable_object.model.MarkList;
import com.walking.lesson21_immutable_object.service.CarService;

import java.util.Scanner;

/**
 * Реализуйте задачу из урока 19.
 * <p>
 * На свое усмотрение, вынесите неизменяемые поля,
 * используемые для идентификации и поиска машины в отдельный immutable класс
 * или сделайте весь класс «Машина» неизменяемым.
 * Правильный выбор зависит от набора полей, который существует в вашей текущей реализации класса «Машина».
 */
public class Main {
    public static void main(String[] args) {
        Car[] cars = initCars();
        CarService carService = new CarService(cars);

        Car searchingCar = carService.searchCar(createCar());

        System.out.println(searchingCar);
    }

    private static IdentityCar createCar() {
        System.out.println("Введите данные машины:");
        System.out.println("Марка:");

        String mark = null;
        String color = null;
        int yearManufacture = 0;
        int stateNumber = 0;

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            mark = scanner.nextLine();
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

        return new IdentityCar(MarkList.setMark(mark), yearManufacture, stateNumber);
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
