package com.walking.lesson16_abstract_class_interface.task2;


import com.walking.lesson16_abstract_class_interface.task2.talk.PhraseDispatcher;


import java.util.Scanner;

public class Main  {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter string: ");
            String s = scanner.nextLine();
            scanner.close();

            PhraseDispatcher phrase = new PhraseDispatcher();
            print(phrase.getPhrase(s));
        }

        private static void print(String s) {
            System.out.println(s);
        }
    }
