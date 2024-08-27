package com.walking.lesson46_lambda.task1;

import java.util.Comparator;
import java.util.LinkedList;

import com.walking.lesson38_comparing.task1.model.Car;

/**
 * Реализуйте
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson38_comparing/task1">Задачу 1 из урока 38</a>
 * описывая компараторы как лямбда-выражения.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Car> cars=initCars();
        Comparator<Car> yearComp=(o1,o2)->{
            int year1=o1.getIdentifier().getYear();
            int year2=o2.getIdentifier().getYear();
            if (year1>year2){
                return 1;
            } else if(year1==year2){
                return 0;
            } else {
                return -1;
            }
        };
        printCars(cars, "After init:");
        cars.sort((o1,o2)->o1.getIdentifier().getNumber().compareTo(o2.getIdentifier().getNumber()));
        printCars(cars, "Sort by number:");
        cars.sort(Comparator.comparing(o->o.getColor()));
        printCars(cars, "Sort by color:");
        cars.sort(yearComp);
        printCars(cars, "Sort by year:");
        Comparator<Car> numb=Comparator.comparing(o->o.getIdentifier().getNumber());
        cars.sort(numb.thenComparing(yearComp));
        printCars(cars, "Sort by number and year:");
    }
    private static LinkedList<Car> initCars(){
        LinkedList<Car> carList=new LinkedList<>();
        carList.add(new Car("e312qw", 2005, "Yellow", true));
        carList.add(new Car("e312qw", 2000, "Green", true));
        carList.add(new Car("a212qw", 2001, "Black", true));
        carList.add(new Car("e307qw", 1999, "White", true));

        return carList;
    }
    private static void printCars(LinkedList<Car> cars, String firstLine){
        System.out.println(firstLine);
        for (Car car : cars) {
            System.out.println(car.getIdentifier().getNumber()+" "+
            car.getIdentifier().getYear()+" "+
            car.getColor()+" "+
            car.isActualTechnicalInspection());
        }
    }
}
// class NumberComp implements Comparator<Car> {
//     @Override
//     public int compare(Car arg0, Car arg1) {
//         return arg0.getIdentifier().getNumber().compareTo(arg1.getIdentifier().getNumber());
//     }  
// }
// class ColorComp implements Comparator<Car> {
//     @Override
//     public int compare(Car arg0, Car arg1) {
//         return arg0.getColor().compareTo(arg1.getColor());
//     }  
// }
// class YearComp implements Comparator<Car> {
//     @Override
//     public int compare(Car arg0, Car arg1) {
//         int year1=arg0.getIdentifier().getYear();
//         int year2=arg1.getIdentifier().getYear();
//         if (year1>year2){
//             return 1;
//         } else if(year1==year2){
//             return 0;
//         } else {
//             return -1;
//         }
//     }  
// }
