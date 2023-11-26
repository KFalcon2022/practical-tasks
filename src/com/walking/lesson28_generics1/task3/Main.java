package Lesson28.Task3;

import Lesson25.Task2.Anonymous.Animal;
import Lesson28.Task2.NotNullGeneric;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] i = {5,3,6,7,2,1,8};
        String[] s = {"haha", "mama", "baba", "lala"};
        ArrayGen<String> arrayGen = new ArrayGen<>(s);
        System.out.println(arrayGen.find("baba"));
    }
}