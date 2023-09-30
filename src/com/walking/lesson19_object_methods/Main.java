package com.walking.lesson19_object_methods;

import com.walking.lesson19_object_methods.models.Car;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

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
public class Main {
    private static HashSet<String> vinTable = new HashSet<>();
    public static void main(String[] args) {
        Car[] cars = new Car[4];
        cars[0]= new Car("Tesla","X",randomVin(),"X117EN799");
        cars[1]= new Car("Rollce Royce","Phantom",randomVin(),"H726KT799");
        cars[2]= new Car("Hyndai","Santa Fe",randomVin(),"C111KK77");
        cars[3]= new Car("Tesla","X",randomVin(),"X117EN799");

        findCar(cars);
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
    private static void findCar(Car[] cars){
        String vin,plateNumber;
        Scanner scannerIn = new Scanner(System.in);
        System.out.println("Enter VIN and plate number to find the car.");
        System.out.print("VIN: ");
        vin=scannerIn.nextLine();
        System.out.print("Plate number: ");
        plateNumber=scannerIn.nextLine();
        scannerIn.close();
        Car checkCar = new Car ("Car for check","Car for check",vin,plateNumber);

        for (Car car:cars){
            if (checkCar.hashCode()==car.hashCode()&&car.equals(checkCar)) {
                System.out.println("Your car was found!");
                System.out.println(car);
                return;
            }
        }
        System.out.println("Unknown car!");
    }
}
