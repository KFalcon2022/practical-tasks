package com.walking.lesson17_enum.task3.model;

import java.util.Scanner;

public interface DataRequire {
    Scanner SCANNER = new Scanner(System.in);

    static int requireInt() {
        return SCANNER.nextInt();
    }
}