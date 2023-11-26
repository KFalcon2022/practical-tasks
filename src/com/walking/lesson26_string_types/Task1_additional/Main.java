package Lesson26.Task1_additional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose your options:\n 1.Enter rectangle values\n 2.Enter length and width at short\n");
        String answer = reader.readLine();
        if (Integer.parseInt(answer) == 1)
        {
            System.out.print("Enter length: ");
            int length = Integer.parseInt(reader.readLine());
            System.out.print("Enter width: ");
            int width = Integer.parseInt(reader.readLine());
            reader.close();
            RectangleBuilder rectangle = new RectangleBuilder(length, width);
        }
        if (Integer.parseInt(answer) == 2)
        {
            System.out.print("Enter your values: ");
            StringBuilder values = new StringBuilder(reader.readLine());
            reader.close();
            RectangleBuilder rectangle = new RectangleBuilder(values);
        }
    }
}