package Lesson26.Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your line: ");
        String answer = reader.readLine();
        System.out.println(new StringSplitter(answer));
    }
}