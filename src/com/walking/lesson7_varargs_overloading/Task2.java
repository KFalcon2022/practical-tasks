package com.walking.lesson7_varargs_overloading;

/**
 * Реализовать методы «вычисления суммы» для всех примитивных типов, кроме void.
 * Возвращать:
 * <p>
 * Для числовых типов — тот же тип. Даже если это ведет к потере точности.
 * При угрозе потери данных — выводить сообщение в консоль и возвращать текущий результат
 * (для byte, short, int);
 * <p>
 * Для boolean — определение истинности всех переданных параметров,
 * принимая то, что их стоит объединять через логическое И;
 * <p>
 * Для char — строку, полученную в результате конкатенации всех переданных параметров.
 * <p>
 * Количество параметров может быть любым.
 * Используйте перегрузку — у всех методов должны быть одинаковые названия.
 */
public class Task2 {
    public static void main(String[] args) {
        System.out.println(sum('h', 'e', 'y'));
        System.out.println(sum(true, false, true));
    }

    static int sum(int... digits) {
        int result = 0;
        for (int element : digits) {
            result += element;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            System.out.println("Результат вычисления выходит за пределы диапазона значений переменной!");
        }
        return result;
    }

    static byte sum(byte... digits) {
        byte result = 0;
        for (byte element : digits) {
            result += element;
        }
        if (result < Byte.MIN_VALUE || result > Byte.MAX_VALUE) {
            System.out.println("Результат вычисления выходит за пределы диапазона значений переменной!");
        }
        return result;
    }

    static short sum(short... digits) {
        short result = 0;
        for (short element : digits) {
            result += element;
        }
        if (result < Short.MIN_VALUE || result > Short.MAX_VALUE) {
            System.out.println("Результат вычисления выходит за пределы диапазона значений переменной!");
        }
        return result;
    }

    static long sum(long... digits) {
        short result = 0;
        for (long element : digits) {
            result += element;
        }
        return result;
    }

    static float sum(float... digits) {
        short result = 0;
        for (float element : digits) {
            result += element;
        }
        return result;
    }

    static double sum(double... digits) {
        short result = 0;
        for (double element : digits) {
            result += element;
        }
        return result;
    }

    static String sum(char... chars) {
        String result = "";
        for (char element : chars) {
            result += element;
        }
        return result;
    }

    static boolean sum(boolean... booleans) {
        boolean result = true;
        for (boolean element : booleans) {
            result = result && element;
        }
        return result;
    }
}
