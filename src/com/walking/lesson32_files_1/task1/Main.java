package com.walking.lesson32_files_1.task1;

import com.walking.lesson32_files_1.task1.models.Car;
import com.walking.lesson32_files_1.task1.service.CarService;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * Используя класс Car (или создав новый класс для сущности «машина», на ваше усмотрение) из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods/model">...</a>
 * Реализуйте сохранение массива машин в файл carCatalog.txt
 */
public class Main {
    private static HashSet<String> vinTable = new HashSet<>();
    public static void main(String[] args) {
        Car[] cars = new Car[4];
        cars[0]= new Car("Tesla","X",randomVin(),"X117EN799");
        cars[1]= new Car("Rollce Royce","Phantom",randomVin(),"H726KT799");
        cars[2]= new Car("Hyndai","Santa Fe",randomVin(),"C111KK77");
        cars[3]= new Car("Tesla","X",randomVin(),"X117EN799");
        CarService carService = new CarService();
        carService.addToFile(cars);
        Car car1 = new Car("VAZ","2108",randomVin(),"F199HJ77");
        carService.addToFile(car1);
        Car car2 = new Car("Porche","Panamera",randomVin(),"F999FF55");
        carService.addToFile(car2);
        //findCar(cars);
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
