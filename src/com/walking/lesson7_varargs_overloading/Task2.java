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
        System.out.println(sum((byte) -120, (byte) 2, (byte) -30));
        System.out.println(sum((short) 1, (short) 2, (short) 3));
        System.out.println(sum(1, 2, 3));
        System.out.println(sum(1L, 2L, 3L));
        System.out.println(sum(1f, 2f, 3f));
        System.out.println(sum(1d, 2d, 3d));
        System.out.println(sum(true, false, true));
        System.out.println(sum('1', '2', '3'));
    }

    static byte sum(byte... bytes) {
        byte result = 0;

        for (byte b : bytes) {
            if (isBeyondLimit(Byte.MIN_VALUE, Byte.MAX_VALUE, result, b)) {
                System.out.println("Переполнение byte. Возврат последнего значения до переполнения");

                return result;
            }

            result += b;
        }

        return result;
    }

    static short sum(short... shorts) {
        short result = 0;

        for (short sh : shorts) {
            if (isBeyondLimit(Short.MIN_VALUE, Short.MAX_VALUE, result, sh)) {
                System.out.println("Переполнение short. Возврат последнего значения до переполнения");

                return result;
            }

            result += sh;
        }

        return result;
    }

    static int sum(int... ints) {
        int result = 0;

        for (int i : ints) {
            if (isBeyondLimit(Integer.MIN_VALUE, Integer.MAX_VALUE, result, i)) {
                System.out.println("Переполнение int. Возврат последнего значения до переполнения");

                return result;
            }

            result += i;
        }

        return result;
    }

    static long sum(long... longs) {
        long result = 0;

        for (long l : longs) {
            result += l;
        }

        return result;
    }

    static float sum(float... floats) {
        float result = 0;

        for (float f : floats) {
            result += f;
        }

        return result;
    }

    static double sum(double... doubles) {
        double result = 0;

        for (double d : doubles) {
            result += d;
        }

        return result;
    }

    static boolean sum(boolean... booleans) {
        for (boolean bool : booleans) {
//            Явное объединение условий по И не имеет смысла.
//            Если хоть одно из них false - результат будет false.
            if (!bool) {
                return false;
            }
        }

        return true;
    }

    static String sum(char... chars) {
        String result = "";

        for (char ch : chars) {
            result += ch;
        }

        return result;
    }

    //    Проверку выхода за границы диапазона типа можно вынести в таком виде.
//    Такой подход заставляет считать лишнюю сумму. Но это можно оптимизировать,
//    предлагаю подумать - как?
    static boolean isBeyondLimit(long minLimit, long maxLimit, long currentSum, long term) {
        long sum = currentSum + term;

        return sum < minLimit || sum > maxLimit;
    }
}
