package com.walking.lesson33.Task1;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class DataBase {
    private final String path;
    private List<Car> data;

    public DataBase(String path){
        this.path = path;
        data = new ArrayList<Car>();
    }

    public void fillWithRandomCars(int quantity){
        data = CarFactory.stream()
                .limit(quantity)
                .collect(Collectors.toList());
    }

    public List<Car> items(){
        return data;
    }

    public boolean saveToFile(){
        try (FileOutputStream fos = new FileOutputStream(path)){
            for (Car car : data){
                fos.write(car.asObject().getBytes());
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
                    data.add(new Car(sb.toString()));
                    sb = new StringBuilder();
                }
                sb.append((char) ch);
            }

            if (!sb.toString().strip().isEmpty()){
                data.add(new Car(sb.toString()));
            }
            return true;

        } catch (IOException e) {
            return false;
        }
    }
}
