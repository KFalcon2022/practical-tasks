package com.walking.lesson38_comparing.task1;

import java.util.Comparator;
import java.util.LinkedList;

import com.walking.lesson38_comparing.task1.model.Car;

/**
 * Используя классы-сущности из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson21_immutable_object/model">...</a>
 * реализуйте сортировку машин по:
 * · Номеру;
 * · Цвету;
 * · Году;
 * · Номеру и году.
 * <p>
 * Используйте список для хранения и сортировки коллекции машин.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Car> cars=initCars();
        printCars(cars, "After init:");
        cars.sort(new NumberComp());
        printCars(cars, "Sort by number:");
        cars.sort(new ColorComp());
        printCars(cars, "Sort by color:");
        cars.sort(new YearComp());
        printCars(cars, "Sort by year:");
        cars.sort(new NumberComp().thenComparing(new YearComp()));
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
class NumberComp implements Comparator<Car> {
    @Override
    public int compare(Car arg0, Car arg1) {
        return arg0.getIdentifier().getNumber().compareTo(arg1.getIdentifier().getNumber());
    }  
}
class ColorComp implements Comparator<Car> {
    @Override
    public int compare(Car arg0, Car arg1) {
        return arg0.getColor().compareTo(arg1.getColor());
    }  
}
class YearComp implements Comparator<Car> {
    @Override
    public int compare(Car arg0, Car arg1) {
        int year1=arg0.getIdentifier().getYear();
        int year2=arg1.getIdentifier().getYear();
        if (year1>year2){
            return 1;
        } else if(year1==year2){
            return 0;
        } else {
            return -1;
        }
    }  
}