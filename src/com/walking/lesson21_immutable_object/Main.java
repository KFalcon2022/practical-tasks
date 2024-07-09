package com.walking.lesson21_immutable_object;

import java.util.Scanner;

import com.walking.lesson21_immutable_object.model.Car;
import com.walking.lesson21_immutable_object.model.Specification;
import com.walking.lesson21_immutable_object.service.CarService;

/**
 * Реализуйте задачу из урока 19.
 * <p>
 * На свое усмотрение, вынесите неизменяемые поля,
 * используемые для идентификации и поиска машины в отдельный immutable класс
 * или сделайте весь класс «Машина» неизменяемым.
 * Правильный выбор зависит от набора полей, который существует в вашей текущей реализации класса «Машина».
 */
public class Main {
    public static void main(String[] args) {
        CarService carService=new CarService(initCars());
        Car requestedCar=requestCar();
        Car foundCar=carService.findCar(requestedCar);
        if (foundCar!=null){
            System.out.println(foundCar.toString());
        }
    }

    private static Car requestCar() {
        Scanner sc=new Scanner(System.in);
        String gosNumber=getValue("Insert number:", sc);;
        String engineVin=getValue("Insert engine vin:", sc);
        String brand=getValue("Insert brand:", sc);
        String model=getValue("Insert model", sc);
        String color=getValue("Insert color:", sc);
        Specification sp=new Specification(brand, model);
        return new Car(gosNumber, engineVin, sp, color);
    }

    private static String getValue(String message, Scanner sc){
        System.out.println(message);
        return sc.nextLine();
    }

    private static Car[] initCars(){
        Specification HyundaiPorter=new Specification("Hyundai", "Porter");
        Specification NissanPrimera=new Specification("Nissan", "Primera");
        Specification VolkswagenGolf=new Specification("Volkswagen", "Golf");
        Car car1=new Car("м785ун", "x7mxkn7fp6m004121", HyundaiPorter, "White");
        Car car2=new Car("м786ун", "x7mxkn7fp6m004122", HyundaiPorter, "Black");
        Car car3=new Car("м787ун", "x7mxkn7fp6m004123", HyundaiPorter, "Grey");
        Car car4=new Car("у462ун", "sjnbaap10u0107597", NissanPrimera, "Blue");
        Car car5=new Car("у463ун", "sjnbaap10u0107598", NissanPrimera, "Blue");
        Car car6=new Car("у464ун", "sjnbaap10u0107599", NissanPrimera, "Green");
        Car car7=new Car("м131вв", "wvwzzz1k26w024582", VolkswagenGolf, "Grey");
        Car car8=new Car("м231вв", "wvwzzz1k26w024583", VolkswagenGolf, "Grey");
        Car[] cars={car1,car2,car3,car4,car5,car6,car7,car8};
        return cars;
    }
}
