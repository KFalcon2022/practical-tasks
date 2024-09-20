package com.walking.lesson49_optional.task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import com.walking.lesson49_optional.task1.model.Car;
import com.walking.lesson49_optional.task1.model.Specification;
import com.walking.lesson49_optional.task1.service.CarService;
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
/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods">...</a>,
 * используя Map.
 * Реализацию выберите исходя из особенностей исходной задачи.
 */
/**
 * Реализуйте задачу 2 урока 43:
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson43_map/task2">...</a>
 * тип возвращаемого значения в методе поиска должен быть Optional<Car>.
 * Если ничего не найдено – верните Optional.empty().
 */
public class Main {
public static void main(String[] args) {
        CarService carService=new CarService(initCars());
        Car requestedCar=requestCar();
        // Car foundCar=carService.findCar(requestedCar);
        // if (foundCar!=null){
        //     System.out.println(foundCar.toString());
        // }
        System.out.println(carService.findCar(requestedCar).map(Car::toString).orElseThrow());
    }

    private static Car requestCar() {
        Scanner sc=new Scanner(System.in);
        String gosNumber=getValue("Insert number:", sc);;
        String engineVin=getValue("Insert engine vin:", sc);
        String brand=getValue("Insert brand:", sc);
        String model=getValue("Insert model", sc);
        int year=Integer.parseInt(getValue("Insert year", sc));
        String color=getValue("Insert color:", sc);
        Specification sp=new Specification(brand, model,year);
        sc.close();
        return new Car(gosNumber, engineVin, sp, color);
    }

    private static String getValue(String message, Scanner sc){
        System.out.println(message);
        return sc.nextLine();
    }

    private static Collection<Car> initCars(){
        ArrayList<Car> list=new ArrayList<>();
        Specification HyundaiPorter=new Specification("Hyundai", "Porter", 1999);
        Specification NissanPrimera=new Specification("Nissan", "Primera", 2005);
        Specification VolkswagenGolf=new Specification("Volkswagen", "Golf", 2020);
        list.add(new Car("м785ун", "x7mxkn7fp6m004121", HyundaiPorter, "White"));
        list.add(new Car("м786ун", "x7mxkn7fp6m004122", HyundaiPorter, "Black"));
        list.add(new Car("м787ун", "x7mxkn7fp6m004123", HyundaiPorter, "Grey"));
        list.add(new Car("у462ун", "sjnbaap10u0107597", NissanPrimera, "Blue"));
        list.add(new Car("у463ун", "sjnbaap10u0107598", NissanPrimera, "Blue"));
        list.add(new Car("у464ун", "sjnbaap10u0107599", NissanPrimera, "Green"));
        list.add(new Car("м131вв", "wvwzzz1k26w024582", VolkswagenGolf, "Grey"));
        list.add(new Car("м231вв", "wvwzzz1k26w024583", VolkswagenGolf, "Grey"));
        return list;
    }
}
