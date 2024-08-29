package com.walking.lesson47_method_reference.task2;

import java.util.LinkedList;

/**
 * Реализуйте Задачу 1, обернув метод выведения записи в консоль
 * (System.out.println()) в собственный статический метод.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<String> ll=new LinkedList<>();
        ll.add("1");
        ll.add("2");
        ll.add("3");
        ll.forEach(Main::print);
    }
    public static void print(Object o){
        System.out.println(o);
    }

}
