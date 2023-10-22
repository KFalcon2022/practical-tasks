package com.walking.lesson32_files_1.task1.service;

import com.walking.lesson32_files_1.task1.models.Car;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class CarService {
    public void addToFile(Car[] carsArray){
        try (FileOutputStream carFos=new FileOutputStream("./resource/lesson_32_files_1/carCatalog.txt")){
            for (Car car : carsArray){
                byte[] buffer=car.toString().getBytes();
                carFos.write(buffer);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void addToFile(Car car){
        try (FileOutputStream carFos=new FileOutputStream("./resource/lesson_32_files_1/carCatalog.txt",true)){
                byte[] buffer=car.toString().getBytes();
                carFos.write(buffer);
            System.out.println("Car is added to the file!");
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public String readCarCatalog() throws IOException {
        StringBuilder carString = new StringBuilder();
        try (FileInputStream carFis=new FileInputStream("./resource/lesson_32_files_1/carCatalog.txt")){
            carString.append(new String (carFis.readAllBytes()));
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return carString.toString();
    }
    private Car createCarFromString(String carString){
        String[] carData= carString.split(";|\\n");
        return new Car(carData[0],carData[1],carData[2],carData[3]);
    }
    public Car[] parseCar(String carString){
        String[] carsStringArray = carString.split("\\n");
        Car[] cars=new Car[carsStringArray.length];
        for (int i=0;i<cars.length;i++){
            cars[i]=createCarFromString(carsStringArray[i]);
        }
        return cars;
    }
    public void displayCars() throws IOException {
        Car[] carsGarage=parseCar(readCarCatalog());
        for (int i=0;i<carsGarage.length;i++){
            System.out.println(i+1+"."+carsGarage[i].displayCar());
        }
    }
    public void deleteCar(Car inputCar) throws IOException {
        String carString=readCarCatalog();
        if (!carString.contains(inputCar.toString())){
            System.out.println("\nEntered car doesn't exist in the file!");
            return;
        }
        Car[] originalCarsArray = parseCar(carString);
        Car[] editedCarsArray = new Car[originalCarsArray.length - 1];
        int index=0;
        for (Car car : originalCarsArray) {
            if (Objects.equals(car, inputCar)) {
                System.out.println("\n\u001B[1mCar was deleted from file: \u001B[0m" + car.displayCar());
                continue;
            }
            editedCarsArray[index]=car;
            index++;
        }
        addToFile(editedCarsArray);
    }
    public void deleteCar(String VIN) throws IOException{
        for (Car car:parseCar(readCarCatalog())){
            if (car.toString().contains(VIN)){
                deleteCar(car);
                return;
            }
        }
        System.out.println("\nCar with entered VIN doesn't exist in the file!");
    }
    public void changeCarData(int carIndex,int fieldIndex, String newFieldData) throws IOException {
        Car[] originalCarsArray = parseCar(readCarCatalog());
        if (carIndex<1||carIndex>originalCarsArray.length){
            System.out.println("Entered car doesn't exist in the file!");
            return;
        }
        if (fieldIndex<1||fieldIndex>4){
            System.out.println("Entered car's parameter doesn't exist!");
            return;
        }
        Car[] editedCarsArray = new Car[originalCarsArray.length];
        int index=0;
        for (Car car : originalCarsArray) {
            if (index==carIndex-1) {
                System.out.println("\n\u001B[1mStart changing car: \u001B[0m" + car.displayCar());
                editedCarsArray[index]=getChangedCar(fieldIndex,newFieldData, car);
                index++;
                continue;
            }
            editedCarsArray[index]=car;
            index++;
        }
        addToFile(editedCarsArray);
    }
    private Car getChangedCar(int fieldIndex, String newFieldData, Car oldCar){
        switch (fieldIndex){
            case (1):
                if (Objects.equals(oldCar.getBrandName(),newFieldData)){
                    System.out.println("You entered the same value. No changes");
                }
                return new Car(newFieldData,oldCar.getModelName(),oldCar.getVIN(), oldCar.getPlateNumber());
            case (2):
                if (Objects.equals(oldCar.getModelName(),newFieldData)){
                    System.out.println("You entered the same value. No changes");
                }
                return new Car(oldCar.getBrandName(), newFieldData,oldCar.getVIN(), oldCar.getPlateNumber());
            case (3):
                if (Objects.equals(oldCar.getVIN(),newFieldData)){
                    System.out.println("You entered the same value. No changes");
                }
                return new Car(oldCar.getBrandName(), oldCar.getModelName(),newFieldData, oldCar.getPlateNumber());
            case (4):
                if (Objects.equals(oldCar.getPlateNumber(),newFieldData)){
                    System.out.println("You entered the same value. No changes");
                }
                return new Car(oldCar.getBrandName(), oldCar.getModelName(),oldCar.getVIN(), newFieldData);
        }
        throw new RuntimeException("System error");
    }
}
