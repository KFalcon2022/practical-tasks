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

    }

    static byte calculateSum(byte... nums) {
        byte result = 0;
        for (byte num : nums) {
            result += num;
        }
        System.out.println("Возможна потеря данных!");
        return result;
    }

    static short calculateSum(short... nums) {
        short result = 0;
        for (short num : nums) {
            result += num;
        }
        System.out.println("Возможна потеря данных!");
        return result;
    }

    static int calculateSum(int... nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        System.out.println("Возможна потеря данных!");
        return result;
    }

    static long calculateSum(long... nums) {
        long result = 0;
        for (long num : nums) {
            result += num;
        }
        return result;
    }

    static float calculateSum(float... nums) {
        float result = 0;
        for (float num : nums) {
            result += num;
        }
        return result;
    }

    static double calculateSum(double... nums) {
        double result = 0;
        for (double num : nums) {
            result += num;
        }
        return result;
    }

    static boolean calculateSum(boolean... values) {
        boolean result = true;
        for (boolean value : values) {
            result = result && value;
        }
        return result;
    }

    static String calculateSum(char... chars) {
        String result = "";
        for (char chr : chars) {
            result += chr;
        }
        return result;
    }
}
