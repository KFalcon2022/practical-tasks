package com.walking.lesson10_static_constants.task3;

public class PrimeNumberSearcher {
    public int amount;
    public int[] primeNumbers = new int[amount];

    public int[] findPrimeNumbers(int amount) {
        for (int i = 0; i < primeNumbers.length; i++) {
            if (i == 0) {
                primeNumbers[i] = 2;
            } else {
                int addingValue = i == 1 ? 1 : 2;
                int number = primeNumbers[i - 1] + addingValue;
                primeNumbers[i] = findNextPrimeNumber(number, primeNumbers, i);
            }
        }
        return primeNumbers;
    }

    //    В данном случае, рекурсивно реализован вызов проверки для нового числа в рамках
    //    заполнения одного элемента массива
    public int findNextPrimeNumber(int number, int[] primeNumbers, int currentIndex) {
        boolean isPrime = isPrime(number, primeNumbers, currentIndex);

        if (isPrime) {
            return number;
        }

        number += 2;

        return findNextPrimeNumber(number, primeNumbers, currentIndex);
    }

    //    Метод проверки конкретного числа на то, является ли оно простым
    public boolean isPrime(int number, int[] primeNumbers, int currentIndex) {
        int j = 0;
        boolean isPrime = true;

        while (isPrime && j < currentIndex && number / primeNumbers[j] > 1) {
            if (number % primeNumbers[j] == 0) {
                isPrime = false;
            } else {
                j++;
            }
        }
        return isPrime;
    }

    //    Логика реализации удобного метода-обертки, по аналогии с предыдущей задачей
    public int sum(int[] numbers) {
        return sum(numbers, 0);
    }

    public int sum(int[] numbers, int i) {
        if (i == numbers.length - 1) {
            return numbers[i];
        }

        return numbers[i] + sum(numbers, i + 1);
    }
}



