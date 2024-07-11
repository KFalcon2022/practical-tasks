package com.walking.lesson32_files_1.task1;

import java.io.FileOutputStream;
import java.io.IOException;

import com.walking.lesson32_files_1.task1.model.Car;
import com.walking.lesson32_files_1.task1.model.Specification;

/**
 * Используя класс Car (или создав новый класс для сущности «машина», на ваше усмотрение) из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods/model">...</a>
 * Реализуйте сохранение массива машин в файл carCatalog.txt
 */
public class Main {
    public static void main(String[] args) {
        Car[] cars=initCars();
        System.out.println(saveCars(cars));    
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
    private static boolean saveCars(Car[] cars){
        StringBuilder stringToSave=new StringBuilder();
        for (Car car : cars) {
            stringToSave.append(car.getStringToSave()+"\n");
        }
        try (FileOutputStream fos=new FileOutputStream("./resource/Cars.txt")) {
            byte[] buffer=stringToSave.toString().getBytes("ISO8859_5");
            fos.write(buffer);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
