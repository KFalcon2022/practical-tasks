package lesson10_static_constants.task3;

public class PrimeNumbersFinder {
//    Вынося массив как константу уровня объекта,
//    мы получаем возможность не передавать ее как параметр.
//    А также использовать массив повторно, если простые числа уже найдены
    public final int[] primeNumbers;

    public PrimeNumbersFinder(int numbersLimit) {
        this.primeNumbers = new int[numbersLimit];
    }

    public int[] findPrimeNumbers() {
//        Если массив уже заполнен - нет смысла пересчитывать
        if (primeNumbers[primeNumbers.length - 1] != 0) {
//            Более верным решением было бы возвраать копию массива.
//            Но мы еще не изучили модификаторы доступа и не можем ограничить получение
//            массива как поля класса, поэтому возвращение копии пока избыточно
            return primeNumbers;
        }

        for (int i = 0; i < primeNumbers.length; i++) {
            if (i == 0) {
                primeNumbers[i] = 2;
            } else {
                int addingValue = i == 1 ? 1 : 2;
                int number = primeNumbers[i - 1] + addingValue;
                primeNumbers[i] = findNextPrimeNumber(number, i);
            }
        }

        return primeNumbers;
    }

    public int findNextPrimeNumber(int number, int currentIndex) {
        boolean isPrime = isPrime(number, currentIndex);

        if (isPrime) {
            return number;
        }

        number += 2;

        return findNextPrimeNumber(number, currentIndex);
    }

    public boolean isPrime(int number, int currentIndex) {
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
}
