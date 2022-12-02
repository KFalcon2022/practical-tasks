package com.walking.lesson16_abstract_class_interface.task22;


import com.walking.lesson16_abstract_class_interface.task22.talk.Phrase;
import com.walking.lesson16_abstract_class_interface.task22.talk.PhraseDispatcher;

import java.util.Scanner;

public class Main  {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter string: ");
            String s = scanner.nextLine();
            scanner.close();

            PhraseDispatcher phrase = new PhraseDispatcher();

        }

        private static void print(String s) {
            switch (s) {
                case :
                    System.out.println();
                    break;

                case :
                    System.out.println();
                    break;

                case :
                    System.out.println();
                    break;

                default:
                    System.out.println(); ;
            }
        }
    }
