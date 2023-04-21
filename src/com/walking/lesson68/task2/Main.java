package com.walking.lesson68.task2;

import com.walking.lesson68.task2.model.Philosopher;
import com.walking.lesson68.task2.model.Runn;

public class Main {
    public static void main(String[] args) {
        Philosopher philosopher1 = new Philosopher();
        Philosopher philosopher2 = new Philosopher();
        Philosopher philosopher3 = new Philosopher();
        Philosopher philosopher4 = new Philosopher();
        Philosopher philosopher5 = new Philosopher();


        philosopher1.setLeft(philosopher5);
        philosopher1.setRight(philosopher2);

        philosopher2.setLeft(philosopher1);
        philosopher2.setRight(philosopher3);

        philosopher3.setLeft(philosopher2);
        philosopher3.setRight(philosopher4);

        philosopher4.setLeft(philosopher3);
        philosopher4.setRight(philosopher5);

        philosopher5.setLeft(philosopher4);
        philosopher5.setRight(philosopher1);


        new Thread(new Runn(philosopher1)).start();
        new Thread(new Runn(philosopher2)).start();
        new Thread(new Runn(philosopher3)).start();
        new Thread(new Runn(philosopher4)).start();
        new Thread(new Runn(philosopher5)).start();
    }
}
