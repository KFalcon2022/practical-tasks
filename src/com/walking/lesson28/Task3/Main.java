package com.walking.lesson28.Task3;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Object[] data = new Object[]{"asd", "wer", "Zczczc", 54, -1e10, 0x95, "test", 'v'};
        TestArray<Object> test = new TestArray<>();
        test.setValues(data);

        try {
            Object found = test.find("Zczczc");
            System.out.println('v');
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
