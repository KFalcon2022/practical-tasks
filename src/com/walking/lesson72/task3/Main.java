package com.walking.lesson72.task3;


import com.walking.lesson72.task3.service.ThreadPool;

public class Main {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();

        threadPool.start();
    }
}
