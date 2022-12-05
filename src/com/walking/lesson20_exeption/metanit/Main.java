package com.walking.lesson20_exeption.metanit;


public class Main {
    public static void main(String[] args) {


        try {
            int result = Factorial.getFactorial(-6);
            System.out.println(result);
        } catch (FactorialException ex) {

            System.out.println(ex.getMessage());
            System.out.println(ex.getNumber());
        }
    }
}

class Factorial {

    public static int getFactorial(int num) throws FactorialException {

        int result = 1;
        System.out.println("wefaef");
        if (num < 1) throw new FactorialException("The number is less than 1", num);
        System.out.println("gads");

        for (int i = 1; i <= num; i++) {

            result *= i;
        }
        return result;
    }
}

class FactorialException extends Exception {

    private int number;

    public int getNumber() {
        return number;
    }

    public FactorialException(String message, int num) {

        super(message);
        number = num;
    }
}