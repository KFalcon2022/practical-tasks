package com.walking.lesson28.Task1;

public class Main {
    public static void main(String[] args) {

        //input
        Test<Number> testLong = new Test<>(Long.valueOf(400));
        Test<Number> testInteger = new Test<>(Integer.valueOf(32));
        Test<Number> testDouble = new Test<>(Double.valueOf(64));
        Test<Number> testFloat = new Test<>(Float.valueOf(64));
        Test<Number> testByte = new Test<>((byte)0x12);//?

        // output
        System.out.println(testLong.getDegree(4));
        System.out.println(testInteger.getDegree(4));
        System.out.println(testDouble.getDegree(4));
        System.out.println(testFloat.getDegree(4));
        System.out.println(testByte.getDegree(4));
    }
}

