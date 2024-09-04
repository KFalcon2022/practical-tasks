package com.walking.lesson60_thread.task2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;

public class MultiThreadTableFiller implements TableFiller {
    @Override
    public void fillTable(int[][] table, IntSupplier value) throws InterruptedException {
        Thread tableFiller = new Thread(tableFillingProcess(table, value), "tableFiller");

        tableFiller.start();

        tableFiller.join();
    }

    private Runnable tableFillingProcess(int[][] table, IntSupplier value) {
        return () -> {
            List<Thread> threadList = new ArrayList<>(table.length);

            for (int[] row : table) {
                Thread rowFiller = new Thread(() -> {
                    Arrays.setAll(row, x -> value.getAsInt());

                }, "rowFiller");

                threadList.add(rowFiller);

                rowFiller.start();
            }

            for (Thread thread : threadList) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
