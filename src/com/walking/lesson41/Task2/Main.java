package com.walking.lesson41.Task2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static final Scanner SC = new Scanner(System.in);
    public static final String SYM_REMOVE = "[,.';_0-9 ]";

    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        String[] array = SC.nextLine().replaceAll(SYM_REMOVE, " ").trim().split(" ");

        for (String word : array){
            words.add(word);
        }
        SC.close();

        System.out.printf("Unique words: %d", words.size());
    }
}
