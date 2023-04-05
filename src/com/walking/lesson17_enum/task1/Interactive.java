package Lesson17.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface Interactive {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static void showMessage()
    {
        System.out.print("Enter your message: ");
    }
    static String getMessage()
    {
        showMessage();
        try {
            String line;
            line = reader.readLine();
            return line;
        } catch (IOException e) {
            System.out.println("Wrong message");
            throw new RuntimeException(e);
        }
    }
}
