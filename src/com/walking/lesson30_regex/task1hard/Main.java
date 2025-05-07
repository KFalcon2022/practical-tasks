package com.walking.lesson30_regex.task1hard;

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
        Pattern firstPattern = Pattern.compile("^\\+\\d{1,3}\s\\(\\d{3}\\)\s\\d{3}-\\d{2}-\\d{2}$");
        Pattern secondPattern = Pattern.compile("^\\+\\d{1,3}\\d{3}\\d{3}\\d{2}\\d{2}$");

        Matcher firstMatcher = firstPattern.matcher(number);
        Matcher secondMatcher = secondPattern.matcher(number);

        return firstMatcher.matches() || secondMatcher.matches();
    }
}