package com.walking.lesson30_regex.task1hard;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        String number1 = scanner.nextLine();
        scanner.close();

        System.out.println(isCorrectNumber(number1));
    }

    public static boolean isCorrectNumber(String number) {
        Pattern pattern1 = Pattern.compile("\\+\\d{1,3}\\s\\(\\d{3}\\)\s\\d{3}-\\d{2}-\\d{2}");
        Pattern pattern2 = Pattern.compile("\\+\\d{1,3}\\d{3}\\d{3}\\d{2}\\d{2}");

        Matcher matcher1 = pattern1.matcher(number);
        Matcher matcher2 = pattern2.matcher(number);

        return matcher1.matches() || matcher2.matches();
    }
}