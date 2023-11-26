package Lesson16.Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstMessage {
    BufferedReader reader;

    public void read()
    {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your message: ");
        try {
            System.out.print(speakable.answer(reader.readLine()));
        } catch (IOException e) {
            System.out.println("Error by entering line");
            throw new RuntimeException(e);
        }
    }
}
