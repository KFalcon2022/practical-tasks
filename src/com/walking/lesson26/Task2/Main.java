package com.walking.lesson26.Task2;

public class Main {

    public static final java.util.Scanner SC = new java.util.Scanner(System.in);
    public static final String SYM_REMOVE = "[,.';_0-9 ]";

    public static void main(String[] args) {
        String input = SC.nextLine();
        SC.close();

        String[] words = input
            .replaceAll(SYM_REMOVE, " ")
            .split(" ");

        StringBuilder sb = new StringBuilder();
        int counter = 0;

        for (String word : words){
            if (!word.isBlank()) {
                String tmp = "," + word + ",";

                if (sb.indexOf(tmp) < 0) {
                    counter++;
                    sb.append(tmp);
                }
            }
        }

        System.out.printf("Unique words: %d", counter);
    }
}
