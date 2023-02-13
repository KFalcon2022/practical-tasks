package com.walking.lesson47_meth_ref.Task1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> test = List.of("abra", "kadabra", "kek");
        test.forEach(System.out::println);
    }
}
