package com.walking.lesson38_comparing.task2;

import com.walking.lesson38_comparing.task2.comparators.CarDownSortComparator;
import com.walking.lesson38_comparing.task2.comparators.CarUpSortComparator;
import com.walking.lesson38_comparing.task2.models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

/**
 * Используя классы-сущности из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson21_immutable_object/model">...</a>,
 * имплементируйте Comparable для Car таким образом,
 * чтобы машины сравнивались по полю identifier. (specification)
 * Объекты CarIdentifier предлагаю сравнивать по номеру и году (если номера почему-то совпали). (или по марке и модели)
 * Если данные CarSpecification совпали, то сравнить по VIN
 * <p>
 * Также реализуйте сортировку коллекции машин в прямом и обратном порядке.
 */
public class Main {
        private static HashSet<String> vinTable = new HashSet<>();
        private static ArrayList<Car> carsArray;
        public static void main (String[]args){
            carsArray = getCarList();
            System.out.println("\nOriginal\n");
            displayArray();

            //CarUpSortComparator compUp = new CarUpSortComparator();
            //carsArray.sort(compUp);
            carsArray.sort(Comparator.naturalOrder());
            System.out.println("\nAfter sort up (a->z)\n");
            displayArray();

            //CarDownSortComparator compDown = new CarDownSortComparator();
            //carsArray.sort(compDown);
            carsArray.sort(Comparator.reverseOrder());
            System.out.println("\nAfter sort down (z->a)\n");
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
