package com.walking.lesson60_thread.task1;

import com.walking.lesson60_thread.task1.thread.MyThread;

/**
 * Напишите программу, которая пишет в консоль текущее время каждый две секунды,
 * пока программа запущена.
 */
public class Main {
    public static void main(String[] args) {
        Thread myThread = new Thread(new MyThread(), "MyThread");
        myThread.start();
    }
}