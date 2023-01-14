package com.walking.lesson38.Task2;

public class Main {
    public static final String path = "./resources/carCatalog.txt";
    public static void main(String[] args){
        DataBase DB = new DataBase(path);

        // Заполнить случайно сгенерированными машинами в количестве n штук
        DB.randomFill(20);
        for (Car car : DB.items()){System.out.println(car);}

        System.out.println("\nСортировка год-номер:"); // позволил себе реализовать более реалистичную сортировку
        DB.sort();
        for (Car car : DB.items()){System.out.println(car);}
    }
}
