package com.walking.lesson30_regex.task1easy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        String number = scanner.nextLine();
        scanner.close();

        System.out.println(isCorrectNumber(number));
    }

    public static boolean isCorrectNumber(String number) {
        Pattern pattern = Pattern.compile("^\\+\\d{1,3}\s\\(\\d{3}\\)\s\\d{3}-\\d{2}-\\d{2}$");

        Matcher matcher = pattern.matcher(number);

        return matcher.matches();
    }
}