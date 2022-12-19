package com.walking.lesson33.Task2;

import com.walking.lesson33.Task1.Car;
import com.walking.lesson33.Task1.DataBase;

public class Main {
    public static final String path = "./resources/carCatalog.txt";

    public static void main(String[] args){
        DataBase DB = new DataBase(path);
        DB.loadFromFile();

        for (Car car : DB.items()){
            System.out.println(car);
        }
    }
}
