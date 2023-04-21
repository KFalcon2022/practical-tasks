package Lesson28.Task2;

import Lesson25.Task2.Anonymous.Animal;
import Lesson28.Task1.PowGeneric;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Animal animal = new Animal();
        NotNullGeneric<Animal> notNullGeneric = new NotNullGeneric<>(animal);
        System.out.println(notNullGeneric.getObject());
    }
}