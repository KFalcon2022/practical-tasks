package com.walking.lesson21_immutable_object;



import com.walking.lesson21_immutable_object.model.Car;
import com.walking.lesson21_immutable_object.model.ColorType;
import com.walking.lesson21_immutable_object.model.IdentityCar;
import com.walking.lesson21_immutable_object.model.MarkType;
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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Марка:");
        String mark = scanner.nextLine();
        System.out.println("Номер:");
        int stateNumber = scanner.nextInt();
        System.out.println("Год выпуска:");
        int yearManufacture = scanner.nextInt();


        scanner.close();

        return new IdentityCar(MarkType.setMark(mark), yearManufacture, stateNumber);
    }

    private static Car[] initCars() {
        return new Car[] {
                new Car(MarkType.AUDI, ColorType.BLACK, 2001, 674921),
                new Car(MarkType.BMW, ColorType.BLUE, 2002, 674922),
                new Car(MarkType.RENAULT, ColorType.GREEN, 2003, 674923),
                new Car(MarkType.LADA, ColorType.RED, 2004, 674924),
                new Car(MarkType.VOLVO, ColorType.GREY, 2005, 674925),
                new Car(MarkType.KIA, ColorType.WHITE, 2006, 674926),
                new Car(MarkType.MAZDA, ColorType.YELOW, 2007, 674927),
                new Car(MarkType.SUZUKI, ColorType.RED, 2008, 674928),
                new Car(MarkType.LADA, ColorType.BLUE, 2009, 674929),
        };
    }
}
