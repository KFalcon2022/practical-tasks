package com.walking.lesson46_lambda.task3;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import com.walking.lesson46_lambda.task3.model.Car;
import com.walking.lesson46_lambda.task3.model.Specification;
import com.walking.lesson46_lambda.task3.service.CarService;

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
        CarService carService=new CarService(initCars());
        String input;
        String help="""
        Для поиска по номеру введите номер
        для поиска по части номера: н43 /gosNumberContains
        для поиска по цвету: Blue /colorIs
        для поиска по диапазону годов выпуска: 1992-2020 /yearBetween
        для повтора справки : help
        для выхода из программы: quit
        """;
        System.out.println(help);
        Scanner sc=new Scanner(System.in);
        Predicate<Car> filter=null;
        while (!(input=sc.nextLine()).equals("quit")) {
            if (input.equals("help")){
                System.out.println(help);
            } else{
                filter=parseRequest(input);
                if (filter!=null){
                    for (Car car : carService.findCars(filter)) {
                        System.out.println(car.toString());
                    }
                }
            }
        }
        sc.close();
    }

    private static Predicate<Car> parseRequest(String input){
        if (Pattern.matches("[а-яА-Я0-9]+\\s/gosNumberContains", input)){
            return x->x.getGosNumber().contains(input.split("/")[0].trim());   
        }
        if (Pattern.matches("[a-zA-Z]+\\s/colorIs", input)){
            return x->x.getColor().equals(input.split("/")[0].trim());   
        }
        if (Pattern.matches("\\d{4}-\\d{4}\\s/yearBetween", input)){
            int before=Integer.parseInt(input.split("-")[0]);
            int after=Integer.parseInt(input.split("/")[0].split("-")[1].trim());
            return x->(before<=x.specification.getYear()&after>=x.specification.getYear());   
        }
        if (Pattern.matches("[а-яА-Я0-9]+", input)){
            return x->x.getGosNumber().equals(input);   
        }
        return null;
    }

    private static LinkedList<Car> initCars(){
        LinkedList<Car> cars=new LinkedList<>();
        Specification HyundaiPorter=new Specification("Hyundai", "Porter", 2005);
        Specification NissanPrimera=new Specification("Nissan", "Primera", 2009);
        Specification VolkswagenGolf=new Specification("Volkswagen", "Golf", 2002);
        cars.add(new Car("м785ун", "x7mxkn7fp6m004121", HyundaiPorter, "White"));
        cars.add(new Car("м786ун", "x7mxkn7fp6m004122", HyundaiPorter, "Black"));
        cars.add(new Car("м787ун", "x7mxkn7fp6m004123", HyundaiPorter, "Grey"));
        cars.add(new Car("у462ун", "sjnbaap10u0107597", NissanPrimera, "Blue"));
        cars.add(new Car("у463ун", "sjnbaap10u0107598", NissanPrimera, "Blue"));
        cars.add(new Car("у464ун", "sjnbaap10u0107599", NissanPrimera, "Green"));
        cars.add(new Car("м131вв", "wvwzzz1k26w024582", VolkswagenGolf, "Grey"));
        cars.add(new Car("м231вв", "wvwzzz1k26w024583", VolkswagenGolf, "Grey"));
        return cars;
    }
}
