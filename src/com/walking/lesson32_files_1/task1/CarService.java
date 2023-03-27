package com.walking.lesson32_files_1.task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public CarService(Car ...cars){
        this.cars = new Car[cars.length];
        System.arraycopy(cars, 0, this.cars, 0, cars.length);
    }

    public void addCar(Car car, boolean addToFile){
        Car[] cars = new Car [this.cars.length + 1];
        System.arraycopy(this.cars, 0, cars, 0, this.cars.length);
        cars[cars.length-1] = car;
        this.cars = new Car[cars.length];
        System.arraycopy(cars, 0, this.cars, 0, cars.length);
        if (addToFile) {
            writeToFile(car);
        }
    }




    private void writeToFile(Car car){
        try (FileOutputStream fos = new FileOutputStream(path, true)){
            String text = car.toString() + "\n";
            fos.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile(){
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(path)){
            int symbol;
            while ((symbol = fis.read()) > -1){
                sb.append((char)symbol);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String s = sb.toString();
        String [] lines = s.split("\n");
        for (String line:lines) {
            String [] pars = line.split("\\s");
            addCar(new Car(pars[2],pars[0],pars[1]), false);
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
