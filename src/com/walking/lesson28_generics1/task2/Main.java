package com.walking.lesson28_generics1.task2;

import com.walking.lesson28_generics1.task2.Obertka.Obertka;

public class Main {
    public static void main(String[] args) {
    Obertka<Object> ob = new Obertka<>(new Object());
    System.out.println(ob.isNull());

    Obertka <Object> ob1 = new Obertka<>(null);
    System.out.println(ob1.isNull());


    }

}
