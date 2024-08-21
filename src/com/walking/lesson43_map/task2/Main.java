package com.walking.lesson43_map.task2;

import java.util.HashMap;
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
/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods">...</a>,
 * используя Map.
 * Реализацию выберите исходя из особенностей исходной задачи.
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Car> cars=new HashMap<>();
        Car temp=new Car("у462ун", "sjnbaap10u0107597",
        "Nissan" , "Primera", "Blue");
        cars.putIfAbsent(temp.hashCode(), temp);
        temp=new Car("р758ае", "wdb1400321a269616",
        "Mercedes-benz", "9320", "Blue");
        cars.putIfAbsent(temp.hashCode(), temp);
        temp=new Car("м785ун","x7mxkn7fp6m004128",
        "Hyundai", "Porter", "White");
        cars.putIfAbsent(temp.hashCode(), temp);
        temp=new Car("м131вв", "wvwzzz1k26w024582",
        "Volkswagen", "Golf", "Grey");
        cars.putIfAbsent(temp.hashCode(), temp);
        String inputGosNumber="";
        String inputEngineVin="";
        System.out.println("Insert gosNumber:");
        Scanner sc=new Scanner(System.in);
        inputGosNumber=sc.nextLine();
        System.out.println("Insert engineVin");
        inputEngineVin=sc.nextLine();
        sc.close();
        temp=new Car(inputGosNumber, inputEngineVin);
        if (cars.containsKey(temp.hashCode())&&cars.get(temp.hashCode()).equals(temp)){
            System.out.println(cars.get(temp.hashCode()).toString());
        } else {
            System.out.println("Not found");
        }

    }
}
