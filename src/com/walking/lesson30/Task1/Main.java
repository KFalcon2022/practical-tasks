package com.walking.lesson30.Task1;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final String R_STRICT = "^\\+7 \\(\\d{3}\\) \\d{3}-\\d{2}-\\d{2}$";
    public static final String R_LOOSE = "^\\+?7|8 ?\\(?\\d{3}\\)? ?\\d{3}-?\\d{2}-?\\d{2}$";
    public static final boolean STRICT_MODE = false;

    public static void main(String[] args){
        /*
        Scanner sc = new Scanner(System.in);
        String tel = sc.nextLine();
        sc.close();
         */
        String[] testNumbers = {
                "+7 (908) 882-45-45",
                "+7(908) 82-45-45",
                "+7 (908) 82-45-45\n",
                "+7 (908) 821-45-45\n",
                "+7 908 8245455",
                "89088245455"
        };

        for (String number: testNumbers) {
            System.out.printf("%s - %s\n", number, isCorrectNumber(number));
        }

    }

    public static boolean isCorrectNumber(String number) {
        return isCorrectNumber(number, STRICT_MODE ? R_STRICT : R_LOOSE);
    }
    public static boolean isCorrectNumber(String number, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(number);
        return match.find();
    }
}
