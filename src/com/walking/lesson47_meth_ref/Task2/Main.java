package com.walking.lesson47_meth_ref.Task2;

import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<String> test = List.of("abra", "kadabra", "kek");

        test.forEach(Main::print);
        //ИЛИ
        //test.forEach(consume::accept);
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static Consumer<String> consume = System.out::println;
}
