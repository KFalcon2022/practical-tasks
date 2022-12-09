package com.walking.lesson21.Task1.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static Region validateRegion(int value) {
        for (Region region : Region.values()) {
            if (region.getValue() == value){
                return region;
            }
        }
        return Region.NONE;
    }

    public static int requireInt(String msg) {
        if (msg != null) {
            System.out.print(msg);
        }
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    public static String requireString(String msg) {
        if (msg != null) {
            System.out.print(msg);
        }
        try {
            return SCANNER.next();
        } catch (InputMismatchException e) {
            return "";
        }
    }
}