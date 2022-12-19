package com.walking.lesson33.Task1;

public class Main {
    public static final String path = "./resources/carCatalog.txt";
    public static void main(String[] args){
        DataBase DB = new DataBase(path);
        DB.fill(20);
        System.out.print(DB.saveToFile());
    }
}
