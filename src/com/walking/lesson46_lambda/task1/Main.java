package com.walking.lesson46_lambda.task1;

import com.walking.lesson38_comparing.task1.models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

/**
 * Реализуйте
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson38_comparing/task1">Задачу 1 из урока 38</a>
 * описывая компараторы как лямбда-выражения.
 */
public class Main {
    private static HashSet<String> vinTable = new HashSet<>();
    private static ArrayList<Car> carsArray;
    public static void main(String[] args) {
        carsArray=getCarList();
        System.out.println("\nOriginal\n");
        displayArray();

        Comparator<Car> compNumber = Comparator.comparing(o -> o.getPlateNumber());
        carsArray.sort(compNumber);
        System.out.println("\nSort by plate number\n");
        displayArray();

        carsArray.sort(Comparator.comparing(o->o.getCarSpecification().getBrandName()));
        System.out.println("\nSort by brand name\n");
        displayArray();

        carsArray.sort(Comparator.comparing(o->o.getVIN()));
        System.out.println("\nSort by VIN\n");
        displayArray();

        Comparator<Car> compNumberVIN = compNumber.thenComparing(o->o.getVIN());
        carsArray.sort(compNumberVIN);
        System.out.println("\nSort by number and VIN\n");
        displayArray();

    }

    private static ArrayList<Car> getCarList(){
        CarSpecification teslaX = new CarSpecification("Tesla","X",3.5, VehicleType.Sedan);
        CarSpecification rollceRoyceFantom = new CarSpecification("Rollce Royce","Fantom",5.0, VehicleType.Sedan);
        CarSpecification kiaCeed = new CarSpecification("KIA","Cee'd",9.5, VehicleType.Hatchback);

        ArrayList<Car> carsArray=new ArrayList<>();

        carsArray.add(new Car(teslaX,randomVin(),"X117EN799"));
        carsArray.add(new Car(rollceRoyceFantom,randomVin(),"H726KT799"));
        carsArray.add(new Car(kiaCeed,randomVin(),"C111KK77"));
        carsArray.add(new Car(teslaX,randomVin(),"X117EN799"));

        return carsArray;
    }
    private static String randomVin(){
        String resultVin = "ZFA";
        Random rnd = new Random();
        for (int i=0;i<14;i++){
            resultVin+=rnd.nextInt(11);
        }
        if (vinTable.contains(resultVin))
            resultVin=randomVin();
        else vinTable.add(resultVin);

        return resultVin;
    }
    private static void displayArray(){
        for (Car car:carsArray){
            System.out.println(car);
        }
    }
}
