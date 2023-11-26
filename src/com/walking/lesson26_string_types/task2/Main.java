package com.walking.lesson26_string_types.task2;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();
        String[] sb = s.split(" ");
        String second="";

        for (int i = 0; i < sb.length; i++) {
            String first= sb[i];
            if (second.contains(sb[i])){
               continue;
            }
            int count;
            if (i==0){
               count =1;
            }else{
            count = 0;}
            for (int j = 1; j < sb.length; j++) {

            if (first.equals(sb[j])) {
                count ++;

            }
            }
            second+= first;
            System.out.println(sb[i] + " "+count);

        }
    }
}