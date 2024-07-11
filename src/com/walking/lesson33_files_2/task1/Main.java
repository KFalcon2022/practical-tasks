package com.walking.lesson33_files_2.task1;

import java.io.*;

import com.walking.lesson32_files_1.task1.model.Car;
import com.walking.lesson32_files_1.task1.model.Specification;

/**
 * Реализуйте Задачу 1 из урока
 * <a href="https://telegra.ph/Rabota-s-fajlami-CHast-I-12-17">...</a>
 * с помощью:
 * <p>
 * Вариант 1: FileWriter;
 * Вариант 2: BufferedOutputStream;
 * Вариант 3: BufferedWriter.
 */
public class Main {
    public static void main(String[] args) {
        File file=new File("./resource/","Cars.txt");
        Car[] cars=initCars();
        System.out.println(saveCarsFw(cars,file));    
        System.out.println(saveCarsBos(cars, file));
        System.out.println(saveCarsBw(cars, file));
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

    private static boolean saveCarsFw(Car[] cars, File file){
        StringBuilder stringToSave=new StringBuilder();
        for (Car car : cars) {
            stringToSave.append(car.getStringToSave()+"\n");
        }
        try (FileWriter fw=new FileWriter(file)) {
            fw.write(stringToSave.toString()); 
            fw.flush();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    private static boolean saveCarsBos(Car[] cars, File file){
        byte[] buffer;
        try (BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file))) {
            for (Car car : cars) {
                buffer=(car.getStringToSave()+"\n").getBytes();
                bos.write(buffer);
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    private static boolean saveCarsBw(Car[] cars, File file){
        try (BufferedWriter bw=new BufferedWriter(new FileWriter(file))) {
            for (Car car : cars) {
                bw.write(car.getStringToSave()+"\n");
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
