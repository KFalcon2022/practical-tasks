package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.filter.*;
import com.walking.lesson46_lambda.task3.menu.Messages;

import java.util.Scanner;

public class FilterService {

    public static Filter get(int num) {
        Scanner in = new Scanner(System.in);
        switch (num) {
            case 1:
                System.out.print(Messages.NUMBER_MESSAGE);
                String number = in.nextLine();
                if (number.length() == 6) {
                    return new FilterByNumber(number);
                } else {
                    return new FilterByNumberSubstring(number);
                }
            case 2:
                System.out.print(Messages.OWNER_MESSAGE);
                return new FilterByOwner(in.nextLine());
            case 3:
                System.out.print(Messages.BRAND_MESSAGE);
                return new FilterByBrand(in.nextLine());
            case 4:
                System.out.print(Messages.YEAR_FIRST_MESSAGE);
                int start = in.nextInt();
                System.out.print(Messages.YEAR_SECOND_MESSAGE);
                int end = in.nextInt();
                return new FilterByYear(start, end);
            case 5:
                System.out.print(Messages.COLOR_MESSAGE);
                return new FilterByColor(in.nextLine());
            default:
                throw new RuntimeException("Неверный ввод. Пожалуйста, введите цифру от 1 до 6: ");
        }
    }
}
