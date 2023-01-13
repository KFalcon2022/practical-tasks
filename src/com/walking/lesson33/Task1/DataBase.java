package com.walking.lesson33.Task1;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;

public class DataBase {
    private final String path;
    private List<Car> data  = new ArrayList<>();

    public DataBase(String path){
        this.path = path;
    }

    public void randomFill(int quantity){
        data = new CarFactory().generate(quantity);
    }

    public List<Car> items(){
        return data;
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
        return new Car(number, owner, model);
    }

    private String carToStr(Car car){
        return String.format("%s:%s:%s", car.getNumber(), car.getOwner(), car.getModel());
    }
}
