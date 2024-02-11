package com.walking.lesson60_thread.task2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ThreadBySectionArrayFillingService implements ArrayFillingService{
    IntRandomGenerator randomGenerator;
    private final int ARRAY_DIVIDER_SIZE=1000;

    public ThreadBySectionArrayFillingService(IntRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public int[][] fill(int[][] array) {
        Arrays.stream(array)
                .map(this::splitArray)
                .flatMap(Collection::stream)
                .map(this::getFillingTask)
                .map(Thread::new)
                .peek(Thread::start)
                .forEach(this::joinThreadNoEx);

        return array;
    }
    private Runnable getFillingTask(int[] array) {
        return () -> {
            for (int i = 0; i < array.length; i++) {
            array[i] = randomGenerator.generate();
            }
        };
    }
    private List<int[]> splitArray(int[] array){
        List<int[]> returnList = new ArrayList<>();
        int dividerBySize = array.length/ARRAY_DIVIDER_SIZE;
        if (dividerBySize==0) dividerBySize=1;

        for (int i=0;i<(dividerBySize);i++){
            returnList.add(Arrays.copyOf(array,array.length/dividerBySize));
        }
        return returnList;
    }
    private void joinThreadNoEx(Thread thread){
        try{
            thread.join();
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Tread by section array filling class";
    }
}
