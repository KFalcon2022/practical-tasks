package com.walking.lesson38_comparing.task2;

import java.util.LinkedList;

import com.walking.lesson38_comparing.task2.model.Car;


/**
 * Используя классы-сущности из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson21_immutable_object/model">...</a>,
 * имплементируйте Comparable для Car таким образом,
 * чтобы машины сравнивались по полю identifier.
 * Объекты CarIdentifier предлагаю сравнивать по номеру и году (если номера почему-то совпали).
 * <p>
 * Также реализуйте сортировку коллекции машин в прямом и обратном порядке.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Car> cars=initCars();
        printCars(cars, "After init:");
        cars=sort(cars,false);
        printCars(cars, "Sort forward:");
        cars=sort(cars,true);
        printCars(cars, "Sort backward:");
    }
    private static LinkedList<Car> sort(LinkedList<Car> cars, boolean back){
        int compare;
        for (int i = 0; i < cars.size()-1; i++) {
            for (int j = 0; j < cars.size()-1; j++) {
                compare=cars.get(j).compareTo(cars.get(j+1));
                if ((compare>0&!back)||(compare<0&back)){
                    cars.add(j, cars.get(j+1));
                    cars.remove(j+2);
                }
            }
        }
        return cars;
    }
      private static LinkedList<Car> initCars(){
        LinkedList<Car> carList=new LinkedList<>();
        carList.add(new Car("z312qw", 2005, "Yellow", true));
        carList.add(new Car("z312qw", 2000, "Green", true));
        carList.add(new Car("v212qw", 2001, "Black", true));
        carList.add(new Car("a307qw", 1999, "White", true));

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
