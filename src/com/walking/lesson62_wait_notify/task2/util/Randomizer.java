package com.walking.lesson62_wait_notify.task2.util;

public class Randomizer {
    public static int getNumber(int max){
        int random=(int)Math.round(Math.random()*max);
        return (random==0)?1:random;
    }
}
