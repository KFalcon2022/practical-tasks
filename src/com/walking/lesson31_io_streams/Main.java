package com.walking.lesson31_io_streams;

import java.io.IOException;

/**
 * Чтение данных с помощью System.in и приведение к примитивным типам или строкам
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(parseByte());
    }

    private static byte parseByte() throws IOException {
        return Byte.parseByte(readString());
    }

    private static short parseShort() throws IOException {
        return Short.parseShort(readString());
    }

    private static int parseInt() throws IOException {
        return Integer.parseInt(readString());
    }

    private static long parseLong() throws IOException {
        return Long.parseLong(readString());
    }

    private static char parseChar() throws IOException {
        String inputString = readString();

        return inputString.charAt(0);
    }

    private static boolean parseBoolean() throws IOException {
        String inputString = readString();

        if (inputString.equalsIgnoreCase("true")) {
            return true;
        }
        if (inputString.equalsIgnoreCase("false")) {
            return false;
        }
        throw new IOException("incorrect input");
    }

    private static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        char ch;
        boolean flag = true;

        while (flag) {
            ch = (char) System.in.read();

            if (ch == '\n') {
                flag = false;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
