package com.walking.lesson31.Task1.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    public final Scanner SCANNER;

    public Validator(Scanner scanner){
        SCANNER = scanner;
    }

    public int requireInt(String msg) {
        if (msg != null) {
            System.out.print(msg);
        }
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    public String requireWord(String msg) {
        if (msg != null) {
            System.out.print(msg);
        }
        try {
            return SCANNER.next();
        } catch (InputMismatchException e) {
            return "";
        }
    }

    public String requireString(String msg) {
        if (msg != null) {
            System.out.print(msg);
        }
        try {
            String result = "";
            while (result.isEmpty()) {
                result = SCANNER.nextLine();
            }
            return result;
        } catch (InputMismatchException e) {
            return "";
        }
    }

    public String capitalize(String value){
        return new StringBuilder()
                .append(value.substring(0, 1).toUpperCase())
                .append(value.substring(1).toLowerCase())
                .toString();
    }
}