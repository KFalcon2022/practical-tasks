package com.walking.lesson33.Task1;

public class Main {
    public static final String path = "./resources/carCatalog.txt";
    public static void main(String[] args){
        DataBase DB = new DataBase(path);

        // Заполнить случайно сгенерированными машинами в количечстве n штук
        DB.randomFill(20);

        // Вывод на экран
        for (Car car : DB.items()){System.out.println(car);}

        // Сохранение в файл
        System.out.print(DB.saveToFile());
    }
}
