package com.walking.lesson31_io_streams;

import com.walking.lesson31_io_streams.exception.CastingException;

import java.io.IOException;

/**
 * Чтение данных с помощью System.in и приведение к примитивным типам или строкам
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(readByte());
        System.out.println(readShort());
        System.out.println(readInt());
        System.out.println(readLong());
        System.out.println(readDouble());
        System.out.println(readFloat());
        System.out.println(readChar());
        System.out.println(readBoolean());
        System.out.println(readString());
    }

    private static byte readByte() throws IOException {
        return Byte.parseByte(readString());
    }

    private static short readShort() throws IOException {
        return Short.parseShort(readString());
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    private static Long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    private static double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    private static float readFloat() throws IOException {
        return Float.parseFloat(readString());
    }

    private static char readChar() throws IOException {
        String input = readString();

        if (input.length() == 1) {
            return input.charAt(0);
        }

        if (input.length() == 2 && input.charAt(1) == '\n') {
            return input.charAt(0);
        }

//        На самом деле, спорное решение.
//        При некорректном вводе будет сформировано исключение для Character,
//        хотя метод предназначен для чтения char
        throw new CastingException(input, Character.class);
    }

    private static boolean readBoolean() throws IOException {
        String input = readString();

        if ("true".equalsIgnoreCase(input)) {
            return true;
        }

        if ("false".equalsIgnoreCase(input)) {
            return false;
        }

        throw new CastingException(input, Boolean.class);
    }

    //    В такой реализации метод будет корректно работать для строк
//    (и символов, т.к. readChar() использует readString()), имеющих только коды от 0 до 256,
//    поскольку считывание происходит побайтово
//    Сюда попадают цифры и буквы латинского алфавита, кириллица - нет. Напомню, что char в Java
//    занимает 2 байта
    private static String readString() throws IOException {
        StringBuilder result = new StringBuilder();

        char ch;
        boolean isInputFinished = false;

        while (!isInputFinished) {
            ch = (char) System.in.read();

            if (ch == '\n') {
                isInputFinished = true;
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
