package com.walking.lesson33_files_2.task1;

import java.io.*;
import java.util.Arrays;

public class CarService {
    Car[] cars;
    final String path = "./carCatalog.txt";


    public CarService(boolean readFromFile){
        cars = new Car[0];
        if (readFromFile){
            readFromFile();
        }
    }

    public CarService(boolean addToFile, Car...cars){
        this.cars = new Car[cars.length];
        System.arraycopy(cars, 0, this.cars, 0, cars.length);
        if (addToFile) {
            for (Car car:cars) {
                writeToFile(car);
            }

        }
    }

    public void addCar(Car car, boolean addToFile){
        Car[] cars = new Car[this.cars.length + 1];
        System.arraycopy(this.cars, 0, cars, 0, this.cars.length);
        cars[cars.length-1] = car;
        this.cars = new Car[cars.length];
        System.arraycopy(cars, 0, this.cars, 0, cars.length);
        if (addToFile) {
            writeToFile(car);
        }
    }

    private void writeToFile(Car car){
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(path,true))){
            String text = car.toString() + "\n";
            fw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while (br.ready()){
                line = br.readLine();
                String [] pars = line.split("\\s");
                addCar(new Car(pars[2],pars[0],pars[1]), false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkCar(String govNumber, String mark, String color){
        for (Car c: cars) {
            if (c.getGovNumber().equals(govNumber) && c.getMark().equals(mark) && c.getColor().equals(color)){
                return true;
            }
        }
        return false;

    }

    @Override
    public String toString() {
        return "CarService{" +
                "cars=" + Arrays.toString(cars) +
                '}';
    }

    public boolean checkCar(Car car){
        for (Car c: cars) {
            if (c.equals(car)){
                return true;
            }
        }
        return false;
    }
}
