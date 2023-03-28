package com.walking.lesson33_files_2.task1;

/**
 * Реализуйте Задачу 1 из урока
 * <a href="https://telegra.ph/Rabota-s-fajlami-CHast-I-12-17">...</a>
 * с помощью:
 * <p>
 * Вариант 1: FileWriter;
 * Вариант 2: BufferedOutputStream;
 * Вариант 3: BufferedWriter.
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car("c111cc","green","kamaz");
        CarService cs = new CarService(true);
        cs.addCar(car, true);
        System.out.println(cs);
    }
}
