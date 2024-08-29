package com.walking.lesson47_method_reference.task3.service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import com.walking.lesson46_lambda.task3.model.Car;

public class FilterService {
    private final static String help="""
        Для поиска по номеру введите номер
        для поиска по части номера: н43 /gosNumberContains
        для поиска по цвету: Blue /colorIs
        для поиска по диапазону годов выпуска: 1992-2020 /yearBetween
        для повтора справки : help
        для выхода из программы: quit
        """;
    public static String getHelp() {
        return help;
    }
    public static Predicate<Car> getFilter(String input){
        if (Pattern.matches("[а-яА-Я0-9]+\\s/gosNumberContains", input)){
            return x->x.getGosNumber().contains(input.split("/")[0].trim());   
        }
        if (Pattern.matches("[a-zA-Z]+\\s/colorIs", input)){
            return x->x.getColor().equals(input.split("/")[0].trim());   
        }
        if (Pattern.matches("\\d{4}-\\d{4}\\s/yearBetween", input)){
            int before=Integer.parseInt(input.split("-")[0]);
            int after=Integer.parseInt(input.split("/")[0].split("-")[1].trim());
            return x->(before<=x.specification.getYear()&after>=x.specification.getYear());   
        }
        if (Pattern.matches("[а-яА-Я0-9]+", input)){
            return x->x.getGosNumber().equals(input);   
        }
        return null;
    }

}
