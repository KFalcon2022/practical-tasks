package com.walking.lesson7_varargs_overloading;

import java.io.IOException;

/**
 * �������� ���������, ������� ���������� ����� ���������� �����,
 * ��������� �� ����� ������.
 * ���������� ������������ ����� ������� � ��������� �����.
 */
public class Task1 {
    public static void main(String[] args) throws IOException {

        String[] words = {"����", "�", "�����", "����", "�������", "��", "���", "��", "�������"};

        System.out.println(concatinateString(words));
    }

    static String concatinateString(String[] words) {

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append(" ");
        }
        return result.toString();
    }
}
