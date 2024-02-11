package com.walking.lesson49_optional.task1.service;

import java.util.Scanner;

public class InputService {
    protected static Scanner scanner = new Scanner(System.in);
    public static String getVIN(){
        System.out.print("Enter VIN: ");
        return scanner.nextLine();
    }
    public static String getPlateNumber(){
        System.out.print("Enter plate number: ");
        return scanner.nextLine();
    }
    public static void close(){
        scanner.close();
    }
}
