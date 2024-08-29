package com.walking.lesson47_method_reference.task3;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Predicate;

import com.walking.lesson46_lambda.task3.model.Car;
import com.walking.lesson46_lambda.task3.model.Specification;
import com.walking.lesson46_lambda.task3.service.CarService;
import com.walking.lesson47_method_reference.task3.service.FilterService;

/**
 * Реализуйте Задачу 3 из урока 46,
 * описав все реализуемые фильтры через method reference’ы.
 * Рекомендую вынести функциональность формирования фильтров в отдельный сервис,
 * если это не было сделано ранее.
 */
public class Main {
    public static void main(String[] args) {
        CarService carService=new CarService(initCars());
        String input;
        System.out.println(FilterService.getHelp());
        Scanner sc=new Scanner(System.in);
        Predicate<Car> filter=null;
        while (!(input=sc.nextLine()).equals("quit")) {
            if (input.equals("help")){
                System.out.println(FilterService.getHelp());
            } else{
                filter=FilterService.getFilter(input);
                if (filter!=null){
                    carService.findCars(filter).forEach(System.out::println);
                    // for (Car car : carService.findCars(filter)) {
                    //     System.out.println(car.toString());
                    // }
                }
            }
        }
        sc.close();
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
