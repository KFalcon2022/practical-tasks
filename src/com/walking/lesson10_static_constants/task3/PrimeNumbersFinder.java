package com.walking.lesson10_static_constants.task3;

import java.util.Scanner;

public class PrimeNumbersFinder {
    public static final Scanner scanner = new Scanner(System.in);
    public final int[] primeNumbers;

    PrimeNumbersFinder() {
        System.out.print("Enter a num: ");
        primeNumbers = new int[scanner.nextInt()];
        scanner.close();
    }

    public void setArrayValue() {
        setArrayValue(primeNumbers);
    }
    public void setArrayValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                array[i] = 2;
                continue;
            }
            int addingValue = i == 1 ? 1 : 2;
            int number = primeNumbers[i - 1] + addingValue;
            primeNumbers[i] = findNextPrimeNumber(number, primeNumbers, i);
            continue;
        }
    }

    static int findNextPrimeNumber(int number, int[] primeNumbers, int i) {
        boolean isPrime = isPrime(number, primeNumbers, i);

        if (isPrime)
            return number;

        number += 2;

        return findNextPrimeNumber(number, primeNumbers, i);
    }

    static boolean isPrime(int number, int[] primeNumbers, int i) {
        int j = 0;
        boolean isPrime = true;

        while (isPrime && j < i && number / primeNumbers[j] > 1) {
            if (number % primeNumbers[j] == 0)
                isPrime = false;
            else
                j++;
        }
        return isPrime;
    }

    public void show() {
        show(primeNumbers);
    }
    public void show(int[] array) {
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }

    void sum() {
        System.out.print("\n" + sum(primeNumbers));
}

    static int sum(int[] array) {
        int result = 0;
        for (int i : array) {
            result += i;
        }
        return result;
    }
}
