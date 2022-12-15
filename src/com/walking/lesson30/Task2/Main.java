package com.walking.lesson30.Task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final String REGEX= "^([А-ЯЁ][а-яё]+(\\-[А-ЯЁ][а-яё]+)?)\\s+([А-ЯЁ][а-яё]+)\\s+([А-ЯЁ][а-яё]+)$";

    public static void main(String[] args){
        /*
        Scanner sc = new Scanner(System.in);
        String tel = sc.nextLine();
        sc.close();
         */
        String[] testNames = {
                "Иванов Иван Иваныч",
                "ИвановИван Иваныч",
                "Ива-нов Иван Иваныч",
                "Ива-Нов Иван Иваныч",
                "Иванов Иван иваныч",
                "89088245455"
        };

        for (String name: testNames) {
            try {
                System.out.printf("Valid name - %s\n", name, makeFIO(name));
            } catch (RuntimeException e) {
                System.out.printf("%s\n", e);
            }
        }

    }

    public static FIO makeFIO(String name) throws RuntimeException {
        try {
            Pattern pattern = Pattern.compile(REGEX);
            Matcher match = pattern.matcher(name);
            boolean result = match.find();
            return new FIO(match.group(1), match.group(2), match.group(3));
        } catch (RuntimeException e) {
            throw new RuntimeException("invalid name - " + name);
        }
    }

    public static class FIO{
        public final String familyName;
        public final String firstName;
        public final String secondName;
        public FIO(String f, String n, String i){
            familyName = f;
            firstName = n;
            secondName = i;
        }

        @Override
        public String toString(){
            return familyName + " " + firstName + " " + secondName;
        }
    }
}