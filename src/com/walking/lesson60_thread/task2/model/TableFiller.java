package com.walking.lesson60_thread.task2.model;

import java.util.function.IntSupplier;

public interface TableFiller {
    void fillTable(int[][] table, IntSupplier value) throws InterruptedException;
}
