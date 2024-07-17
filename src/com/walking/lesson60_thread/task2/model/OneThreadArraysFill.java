package com.walking.lesson60_thread.task2.model;

public class OneThreadArraysFill implements ArraysFill {
    private final IntRandomGenerate intRandomGenerate;

    public OneThreadArraysFill(IntRandomGenerate intRandomGenerate) {
        this.intRandomGenerate = intRandomGenerate;
    }

    @Override
    public int[][] fill(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = intRandomGenerate.generate();
            }
        }

        return array;
    }
}
