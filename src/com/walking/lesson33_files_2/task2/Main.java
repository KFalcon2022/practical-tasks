package com.walking.lesson33_files_2.task2;

import java.io.*;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.walking.lesson32_files_1.task1.model.Car;
import com.walking.lesson32_files_1.task1.model.Specification;

/**
 * Реализуйте Задачу 2 из урока
 * <a href="https://telegra.ph/Rabota-s-fajlami-CHast-I-12-17">...</a>
 * с помощью:
 * <p>
 * Вариант 1: FileReader;
 * Вариант 2: BufferedInputStream;
 * Вариант 3: BufferedReader.
 */
public class Main {
    public static void main(String[] args) {
        File file=new File("./resource/","Cars.txt");
        printCars(loadCarsFr(file));
        printCars(loadCarsBis(file));
        printCars(loadCarsBr(file));
    }

    private static Car[] deserialize(StringBuilder input){
        String stringCars=new String(input);
        Car[] cars=new Car[count(stringCars,"gosNumber:")];
        Pattern gosNumberPattern=Pattern.compile("gosNumber:[\\wа-яА-Я]+");
        Pattern engineVinPattern=Pattern.compile("engineVin:[\\wа-яА-Я]+");
        Pattern modelPattern=Pattern.compile("model:[\\wа-яА-Я]+");
        Pattern brandPattern=Pattern.compile("brand:[\\wа-яА-Я]+");
        Pattern colorPattern=Pattern.compile("color:[\\wа-яА-Я]+");
        Matcher gosNumberMatcher=gosNumberPattern.matcher(stringCars);
        Matcher engineVinMatcher=engineVinPattern.matcher(stringCars);
        Matcher modelMatcher=modelPattern.matcher(stringCars);
        Matcher brandMatcher=brandPattern.matcher(stringCars);
        Matcher colorMatcher=colorPattern.matcher(stringCars);
        for (int i = 0; i < cars.length; i++) {
            gosNumberMatcher.find();
            engineVinMatcher.find();
            modelMatcher.find();
            brandMatcher.find();
            colorMatcher.find();
            cars[i]=new Car(gosNumberMatcher.group().substring(10),
             engineVinMatcher.group().substring(10),
             new Specification(brandMatcher.group().substring(6), modelMatcher.group().substring(6)),
              colorMatcher.group().substring(6));
        }
        return cars;
    }

    private static Car[] loadCarsBr(File file) {
        StringBuilder temp=new StringBuilder();
        try (BufferedReader br=new BufferedReader(new FileReader(file))) {
            int c;
            while ((c=br.read())!=-1) {
                temp.append((char)c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return deserialize(temp);
    }

    private static Car[] loadCarsBis(File file) {
        StringBuilder temp=new StringBuilder();
        try (BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file))) {
            temp.append(new String(bis.readAllBytes(), Charset.forName("UTF-8")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return deserialize(temp);
    }

    private static Car[] loadCarsFr(File file) {
        StringBuilder temp=new StringBuilder();
        try (FileReader fr=new FileReader(file)) {
            int c;
            while ((c=fr.read())!=-1) {
                temp.append((char)c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return deserialize(temp);
    }

    private static void printCars(Car[] cars){
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println("\n");
    }

    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
}
