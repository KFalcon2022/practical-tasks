package com.walking.lesson60_thread.task2.model;

import java.util.function.IntSupplier;

public class ExtremeMultiThreadTableFiller implements TableFiller {
    private static final int MAX_ELEMENTS_IN_THREAD = 500_000_000;

    @Override
    public void fillTable(int[][] table, IntSupplier value) throws InterruptedException {
        Thread tableFiller = new Thread(tableFillingProcess(table, value), "tableFiller");

        tableFiller.start();

        tableFiller.join();
    }

    private Runnable tableFillingProcess(int[][] table, IntSupplier value) throws InterruptedException {
        return () -> {
           /* List<Thread> threadList = new ArrayList<>(table.length);*/

            for (int[] row : table) {
                int partCount = Math.max(1, row.length / MAX_ELEMENTS_IN_THREAD);

                Thread rowFiller = new Thread(() -> {
                    try {
                        fillRow(row, partCount, value);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, "rowFiller");

               /* threadList.add(rowFiller);*/

                rowFiller.start();
            }

            /*for (Thread thread : threadList) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }*/
        };
    }

    private void fillRow(int[] row, int partCount, IntSupplier value) throws InterruptedException {
        /*List<Thread> threadList = new ArrayList<>(partCount);*/

        int offset = row.length / partCount;
        int startIndex = 0;
        int endIndex = offset;

        for (int i = 0; i < partCount; i++) {
            fillRowPart(row, startIndex, endIndex, value/*, threadList*/);

            startIndex += offset;
            endIndex += offset;
        }

        /*for (Thread thread : threadList) {
            thread.join();
        }*/
    }

    private void fillRowPart(int[] row, int startInclusive, int endExclusive,
            IntSupplier value/*, List<Thread> threadList*/) throws InterruptedException {
        Thread partRowFiller = new Thread(partRowFillingProcess(row, startInclusive, endExclusive, value),
                "partRowFiller");

        /*threadList.add(partRowFiller);*/

        partRowFiller.start();
    }

    private Runnable partRowFillingProcess(int[] row, int startInclusive, int endExclusive, IntSupplier value) {
        return () -> {
            for (int i = startInclusive; i < endExclusive; i++) {
                row[i] = value.getAsInt();
            }
        };
    }
}