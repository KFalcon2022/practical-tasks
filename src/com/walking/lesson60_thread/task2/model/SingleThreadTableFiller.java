package com.walking.lesson60_thread.task2.model;

import java.util.Arrays;
import java.util.function.IntSupplier;

public class SingleThreadTableFiller implements TableFiller {
    @Override
    public void fillTable(int[][] table, IntSupplier value) throws InterruptedException {
        Thread tableFiller = new Thread(tableFillingProcess(table, value), "tableFiller");

        tableFiller.start();

        tableFiller.join();
    }

    private Runnable tableFillingProcess(int[][] table, IntSupplier value) {
        return () -> {
            for (int[] row : table) {
                Arrays.setAll(row, x -> value.getAsInt());
            }
        };
    }
}
