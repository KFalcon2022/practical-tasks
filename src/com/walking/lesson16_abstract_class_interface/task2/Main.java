package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.talk.Bye;
import com.walking.lesson16_abstract_class_interface.task2.talk.Hi;
import com.walking.lesson16_abstract_class_interface.task2.talk.How;
import com.walking.lesson16_abstract_class_interface.task2.talk.Phrases;

import java.util.Scanner;

public class Main implements Hi, Bye, How {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter string: ");
            String s = scanner.nextLine();
            scanner.close();

            Phrases phrase = new Phrases(s);
        }
    }
