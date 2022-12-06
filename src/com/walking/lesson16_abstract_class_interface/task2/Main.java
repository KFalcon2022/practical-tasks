package com.walking.lesson16_abstract_class_interface.task2;


import com.walking.lesson16_abstract_class_interface.task2.talk.Phrase;
import com.walking.lesson16_abstract_class_interface.task2.talk.answer.Bye;
import com.walking.lesson16_abstract_class_interface.task2.talk.answer.Hi;
import com.walking.lesson16_abstract_class_interface.task2.talk.answer.How;
import com.walking.lesson16_abstract_class_interface.task2.talk.answer.Unknown;


import java.util.Scanner;

public class Main  {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter string: ");
            String s = scanner.nextLine();
            scanner.close();

            Phrase phrase;

            switch (s) {
                case "Hi":
                    phrase = new Hi();
                    break;

                case "Bye":
                    phrase = new Bye();
                    break;

                case "How are you":
                    phrase = new How();

                default: phrase = new Unknown();
            }

            System.out.println(phrase.getPhrase());
        }

    }
