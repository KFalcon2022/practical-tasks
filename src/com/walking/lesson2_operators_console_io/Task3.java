package com.walking.lesson2_operators_console_io;

public class Task3 {
    public static void main(String[] args) {
        int a = 1; // a присваивается 1

        int b = a++; // сначала b присваивается a (b == 1), затем а увеличивается на 1 (а == 2)

        b += a++; // сначала b = b + a (b == 3) , затем а увеличивается на 1 ( а == 3)

        System.out.println(b); // должно вывести 3
    }
}
