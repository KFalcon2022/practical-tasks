package com.walking.lesson19_object_methods;

import java.util.Scanner;

import com.walking.lesson19_object_methods.model.Car;

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
    public static void main(String[] args) {
        Car[] carArray= new Car[4];
        carArray[0]=new Car("у462ун", "sjnbaap10u0107597",
         "Nissan" , "Primera", "Blue");
        carArray[1]=new Car("р758ае", "wdb1400321a269616",
         "Mercedes-benz", "9320", "Blue");
        carArray[2]=new Car("м785ун","x7mxkn7fp6m004128",
          "Hyundai", "Porter", "White");
        carArray[3]=new Car("м131вв", "wvwzzz1k26w024582",
        "Volkswagen", "Golf", "Grey");
        String inputGosNumber="";
        String inputEngineVin="";
        System.out.println("Insert gosNumber:");
        Scanner sc=new Scanner(System.in);
        inputGosNumber=sc.nextLine();
        System.out.println("Insert engineVin");
        inputEngineVin=sc.nextLine();
        sc.close();
        System.out.println(findCar(inputGosNumber, inputEngineVin, carArray));

    }

    private static String findCar(String inputGosNumber, String inputEngineVin, Car[] carArray) {
        Car tempCar=new Car(inputGosNumber, inputEngineVin);
        String result=null;
        for (Car x:carArray){
            if (x.hashCode()==tempCar.hashCode()&&x.equals(tempCar)){
                result=x.toString();
            }
        }
        if (result==null){
            result="Машина не найдена";
        }
        return result;
    }
}
