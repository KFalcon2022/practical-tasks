package com.walking.lesson64_thread_methods.task2_1;

public class Randomizer {
    public static int getNumber(int max){
        int random=(int)Math.round(Math.random()*max);
        return (random==0)?1:random;
    }
}
