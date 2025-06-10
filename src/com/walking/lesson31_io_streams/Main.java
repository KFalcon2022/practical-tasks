package com.walking.lesson31_io_streams;

import com.walking.lesson31_io_streams.exeption.WrongTypeExeption;

import java.io.IOException;

/**
 * Чтение данных с помощью System.in и приведение к примитивным типам или строкам
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(readChar());
        System.out.println(readByte());
        System.out.println(readInt());
        System.out.println(readString());
        System.out.println(readBoolean());

    }

    public static byte readByte() throws IOException {
        return Byte.parseByte(readString());
    }

    public static int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    public static char readChar() throws IOException {
        String string = readString();

        if (string.length() == 1 || string.length() == 2 && string.charAt(1) == '\n') {
            return string.charAt(0);
        }
        throw new WrongTypeExeption("%s не может быть представлено в виде символа".formatted(string));
    }

    public static boolean readBoolean() throws IOException {
        String string = readString();

        if ("false".equalsIgnoreCase(string)) {
            return false;
        }

        if ("true".equalsIgnoreCase(string)) {
            return true;
        }
        throw new WrongTypeExeption("%s не похоже на boolean".formatted(string));
    }

    public static String readString() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFinished = false;

        while (!isFinished) {
            char ch = (char) System.in.read();

            if (ch == '\n') {
                isFinished = true;
            } else {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }
}
