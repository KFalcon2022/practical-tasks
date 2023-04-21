package Lesson28.Task1;

import Lesson26.Task1_additional.RectangleBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your number, you want to Pow: ");
        Integer answer = Integer.parseInt(reader.readLine().trim());
        System.out.print("Enter pow number: ");
        Byte powNumber = Byte.parseByte(reader.readLine().trim());
        reader.close();
        PowGeneric<Integer> pow = new PowGeneric<>(answer);
        System.out.println(pow.getPow(powNumber));
    }
}