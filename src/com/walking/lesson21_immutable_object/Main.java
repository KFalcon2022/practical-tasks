package com.walking.lesson21_immutable_object;

import com.walking.lesson21_immutable_object.models.Car;
import com.walking.lesson21_immutable_object.models.CarSpecification;
import com.walking.lesson21_immutable_object.models.VehicleType;
import org.w3c.dom.css.CSSRule;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * Реализуйте задачу из урока 19.
 * <p>
 * На свое усмотрение, вынесите неизменяемые поля,
 * используемые для идентификации и поиска машины в отдельный immutable класс
 * или сделайте весь класс «Машина» неизменяемым.
 * Правильный выбор зависит от набора полей, который существует в вашей текущей реализации класса «Машина».
 */
/**
 * Исходное условие
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
    private static CarSpecification testCar = new CarSpecification("Test","Test",0,VehicleType.Minivan);
    public static void main(String[] args) {
        CarSpecification teslaX = new CarSpecification("Tesla","X",3.5, VehicleType.Sedan);
        CarSpecification rollceRoyceFantom = new CarSpecification("Rollce Royce","Fantom",5.0,VehicleType.Sedan);
        CarSpecification kiaCeed = new CarSpecification("KIA","Cee'd",9.5,VehicleType.Hatchback);
        Car[] cars = new Car[4];
        cars[0]= new Car(teslaX,randomVin(),"X117EN799");
        cars[1]= new Car(rollceRoyceFantom,randomVin(),"H726KT799");
        cars[2]= new Car(kiaCeed,randomVin(),"C111KK77");
        cars[3]= new Car(teslaX,randomVin(),"X117EN799");

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
        Scanner scannerIn = new Scanner(System.in);
        System.out.println("\nEnter VIN and plate number to find the car.");
        System.out.print("VIN: ");
        String vin=scannerIn.nextLine();
        System.out.print("Plate number: ");
        String plateNumber=scannerIn.nextLine();
        scannerIn.close();
        Car carForCheck = new Car (testCar,vin,plateNumber);

        for (Car car:cars){
            if (carForCheck.hashCode()==car.hashCode()&&car.equals(carForCheck)) {
                System.out.println("\nYour car was found!\n");
                System.out.println(car);
                return;
            }
        }
        System.out.println("Unknown car!");
    }
}
