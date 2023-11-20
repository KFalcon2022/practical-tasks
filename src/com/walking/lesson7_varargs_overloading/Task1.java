package com.walking.lesson7_varargs_overloading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * �������� ���������, ������� ���������� ����� ���������� �����,
 * ��������� �� ����� ������.
 * ���������� ������������ ����� ������� � ��������� �����.
 */
public class Task1 {
    public static void main(String[] args) throws IOException {
        System.out.println("������� ��������� ����\n" +
                "(��� ������ �� ��������� ������� \"exit\"): ");

        System.out.println(concatinatingString());
    }

    static String concatinatingString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        String word;
        do {
            word = reader.readLine();
            result.append(word).append(" ");
        } while (!word.equals("exit"));
        reader.close();
        return result.toString();
    }
}
