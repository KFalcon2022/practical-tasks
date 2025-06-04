package com.walking.lesson18_instanceof_getClass.task1_getClass.model;

public class Dog extends Animal {
    //    Передаем параметры в super внутри конструктора, а не принимая их в параметры Cat(),
//    чтобы избежать ошибочного поведения при использовании этого класса
    public Dog() {
        super("woof");
    }

    public void woof() {
        sound();
    }
}
