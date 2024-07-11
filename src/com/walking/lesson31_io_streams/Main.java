package com.walking.lesson31_io_streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Чтение данных с помощью System.in и приведение к примитивным типам или строкам
 */
public class Main {
    public static void main(String[] args) {
        String s=null;
        int i;
        float f;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            s=new String(br.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (s!=null){
            try {
                i=Integer.parseInt(s);
                System.out.println(i);
            } catch (Exception e) {
                // TODO: handle exception
            }
            try {
                f=Float.parseFloat(s);
                System.out.println(f);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println(s);
        }
    }
}
