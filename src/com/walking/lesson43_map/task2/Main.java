package com.walking.lesson43_map.task2;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods">...</a>,
 * используя Map.
 * Реализацию выберите исходя из особенностей исходной задачи.
 */

import com.walking.lesson19_object_methods.model.Car;

import java.util.*;

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
        HashMap<Integer,Car> carsArray = new HashMap<>();
        Car car1=new Car("Tesla","X",randomVin(),"X117EN799");
        carsArray.put(car1.hashCode(),car1);
        car1=new Car("Rollce Royce","Phantom",randomVin(),"H726KT799");
        carsArray.put(car1.hashCode(),car1);
        car1=new Car("Hyndai","Santa Fe",randomVin(),"C111KK77");
        carsArray.put(car1.hashCode(),car1);
        car1=new Car("Tesla","X",randomVin(),"X117EN799");
        carsArray.put(car1.hashCode(),car1);
        findCar(carsArray);
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
    private static void findCar(HashMap<Integer,Car> cars){
        String vin,plateNumber;
        Scanner scannerIn = new Scanner(System.in);
        System.out.println("Enter VIN and plate number to find the car.");
        System.out.print("VIN: ");
        vin=scannerIn.nextLine();
        System.out.print("Plate number: ");
        plateNumber=scannerIn.nextLine();
        scannerIn.close();
        Car checkCar = new Car ("Car for check","Car for check",vin,plateNumber);

        for (Map.Entry<Integer,Car> item : cars.entrySet()){
            if (checkCar.hashCode()==item.getKey()&&item.getValue().equals(checkCar)) {
                System.out.println("Your car was found!");
                System.out.println(item.getValue());
                return;
            }
        }
        System.out.println("Unknown car!");
    }
}