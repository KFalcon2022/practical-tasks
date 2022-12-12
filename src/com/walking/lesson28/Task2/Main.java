package com.walking.lesson28.Task2;

public class Main {

    public static String PATTERN = "Value: %s, empty: %b\n";

    public static void main(String[] args) {
        Test<String> test = new Test<>("Test String");
        System.out.printf(PATTERN, test.getValue(), test.isEmpty());
        test.setValue(null);
        System.out.printf(PATTERN, test.getValue(), test.isEmpty());
    }
}
