package com.walking.lesson21.Task1.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static Region validateRegion(int value) {
        Region result = Region.NONE;
        for (Region r : Region.values()) {
            if (r.getValue() == value){
                result = r;
                break;
            }
        }
        return result;
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