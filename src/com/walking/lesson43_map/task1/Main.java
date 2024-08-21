package com.walking.lesson43_map.task1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.walking.lesson28_generics1.task4.model.Stack;

/**
 * Реализуйте программу, выводящую в консоль количество использований каждого из уникальных слов
 * во введенной пользователем строке.
 * <p>
 * За основу предлагаю взять реализацию из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson30_regex/task3">...</a>.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Insert some words:");
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        sc.close();
        LinkedHashMap<String,Integer> map=getWordUseCount(input);
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println("Word: "+entry.getKey()+" used "+entry.getValue()+" times");
        }

    }
    private static LinkedHashMap<String,Integer> getWordUseCount(String s){
        Pattern pattern=Pattern.compile("[а-яА-ЯA-Za-z-]+");
        Matcher matcher=pattern.matcher(s);
        LinkedHashMap<String,Integer> map=new LinkedHashMap<>();
        while (matcher.find()) {
            if (!matcher.group().matches("^.*-{2,}.*$")){
                if (map.containsKey(matcher.group())){
                    map.put(matcher.group(),map.get(matcher.group())+1);
                } else{
                    map.put(matcher.group(),1);
                }
            }
        }
        return map;
    }
}
