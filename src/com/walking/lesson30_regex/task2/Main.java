package com.walking.lesson30_regex.task2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ââåäèòå ÔÈÎ:");
        String fullName = scanner.nextLine();
        scanner.close();

        System.out.println(checkFullName(fullName));
    }

    public static FullName checkFullName(String fullName) {
        Pattern pattern = Pattern.compile("^[À-ß¨&&[^ÚÛÜ]][à-ÿ¸]+(-[À-ß¨&&[^ÚÛÜ]][à-ÿ¸]+)?\s[À-ß¨&&[^ÚÛÜ]][à-ÿ¸]+\s[À-ß¨&&[^ÚÛÜ]][à-ÿ¸]+$");
        Matcher matcher = pattern.matcher(fullName);

        if (!matcher.matches()) {
            throw new IncorrectInputException();
        }

        String[] splitFullName = fullName.split("\s");
        String surname = splitFullName[0];
        String name = splitFullName[1];
        String patronymic = splitFullName[2];
        FullName result = new FullName(surname, name, patronymic);

        return result;
    }
}