package com.walking.lesson26.Task2;
import java.util.Scanner;

public class Main {

    public static final Scanner SC = new Scanner(System.in);
    public static final String SYM_REMOVE = "[,.';_0-9 ]";

    public static void main(String[] args) {
        String input = SC.nextLine();
        SC.close();

        String[] words = input
            .replaceAll(SYM_REMOVE, " ")
            .split(" ");

        int counter = 0;

        for (int i = 0; i < words.length; i++){
            if (!words[i].isBlank()) {
                boolean unique = true;
                for (int j = i + 1; unique && j < words.length; j++) {
                    if (words[j].equals(words[i])) {
                        unique = false;
                    }
                }
                if (unique) {
                    counter++;
                }
            }
        }

        System.out.printf("Unique words: %d", counter);
    }
}
