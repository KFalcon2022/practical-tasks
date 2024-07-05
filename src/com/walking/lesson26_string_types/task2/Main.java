package com.walking.lesson26_string_types.task2;

import java.util.Scanner;

/**
 * Реализуйте программу, принимающую с клавиатуры строку,
 * содержащую слова, разделенные пробелом.
 * Выведите в консоль количество уникальных слов в строке.
 * Учтите, что строка может начинаться с пробела.
 * <p>
 * Для упрощения допустим, что в строке не могут использоваться символы,
 * отличные от пробела или русских/английский букв.
 * Помните, что слово может быть введено в разных регистрах.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите строку:");
        String s=sc.nextLine();
        sc.close();
        String[] arr=s.strip().split(" ");
        String[] unique=new String[arr.length];
        unique[0]=arr[0];
        boolean flag;
        int uniqueCounter=1;
        for (int i=1; i<arr.length;i++){
            flag=true;
            for (int j=0; j<uniqueCounter;j++){
                if (arr[i].equals(unique[j]))
                    flag=false;
            }
            if (flag){
                unique[uniqueCounter]=arr[i];
                uniqueCounter++;
            }
        }
        System.out.printf("Вы ввели %d уникальных слов(а)", uniqueCounter);
    }
}
