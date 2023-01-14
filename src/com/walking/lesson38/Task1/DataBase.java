package com.walking.lesson38.Task1;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class DataBase {
    private final String path;
    private List<Car> data  = new ArrayList<>();
    private final Comparator<Car> ComparesModel = new CarModelComparator();
    private final Comparator<Car> ComparesOwner = new CarOwnerComparator();
    private final Comparator<Car> ComparesYear = new CarYearComparator();
    private final Comparator<Car> ComparesNumber = new CarNumberComparator();

    public DataBase(String path){
        this.path = path;
    }

    public void randomFill(int quantity){
        data = new CarFactory().generate(quantity);
    }

    public List<Car> items(){
        return data;
    }

    public List<Car> itemsSortedByModel(){
        return data.stream()
                .sorted(ComparesModel)
                .collect(Collectors.toList());
    }

    public List<Car> itemsSortedByOwner(){
        return data.stream()
                .sorted(ComparesOwner)
                .collect(Collectors.toList());
    }

    public List<Car> itemsSortedByYearNumber(){
        return data.stream()
                .sorted(ComparesYear.thenComparing(ComparesNumber)) // Но можно было и составной компаратор объявить выше
                .collect(Collectors.toList());
    }

    public boolean saveToFile(){
        try (FileOutputStream fos = new FileOutputStream(path)){
            for (Car car : data){
                fos.write(carToStr(car).getBytes());
                fos.write(System.getProperty("line.separator").getBytes());
            }
            fos.flush();
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public boolean loadFromFile(){
        try (InputStreamReader fis = new InputStreamReader(new FileInputStream(path), "UTF-8")){
            data.clear();
            int ch;

            StringBuilder sb = new StringBuilder();
            while ((ch = fis.read()) != -1){
                if ((char) ch == System.getProperty("line.separator").charAt(0)){
                    data.add(strToCar(sb.toString()));
                    sb = new StringBuilder();
                }
                sb.append((char) ch);
            }

            if (!sb.toString().strip().isEmpty()){
                data.add(strToCar(sb.toString()));
            }
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    private Car strToCar(String data){
        String[] parts = data.strip().split(":");
        String number = parts.length > 0 ? parts[0] : "";
        String owner = parts.length > 1 ? parts[1] : "";
        String model = parts.length > 2 ? parts[2] : "";
        int year = parts.length > 3 ? Integer.valueOf(parts[3]) : 2023;
        return new Car(number, owner, model, year);
    }

    private String carToStr(Car car){
        return String.format("%s:%s:%s", car.getNumber(), car.getOwner(), car.getModel());
    }
}
