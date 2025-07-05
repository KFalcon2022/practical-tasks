package com.walking.lesson18_instanceof_getClass.task1_instanceof.model;

public class Cow extends Animal {
    //    Передаем параметры в super внутри конструктора, а не принимая их в параметры Cat(),
//    чтобы избежать ошибочного поведения при использовании этого класса
    public Cow() {
        super("moo");
    }

    public void moo() {
        sound();
    }
}
