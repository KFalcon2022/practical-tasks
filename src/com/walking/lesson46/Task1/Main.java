package com.walking.lesson46.Task1;

public class Main {
    public static final String path = "./resources/carCatalog.txt";

    public static void main(String[] args) {
        DataBase DB = new DataBase(path);

        // Заполнить случайно сгенерированными машинами в количестве n штук
        DB.randomFill(20);
        for (Car car : DB.items()) {
            System.out.println(car);
        }

        System.out.println("\nСортировка по названию модели:");
        for (Car car : DB.itemsSortedByModel()) {
            System.out.println(car);
        }

        System.out.println("\nСортировка по имени владельца:");
        for (Car car : DB.itemsSortedByOwner()) {
            System.out.println(car);
        }

        System.out.println("\nСортировка по имени году и номеру:");
        for (Car car : DB.itemsSortedByYearNumber()) {
            System.out.println(car);
        }
    }
}
