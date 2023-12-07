package com.walking.lesson37_collection_list.task1.service;

import com.walking.lesson37_collection_list.task1.model.Counter;

import java.util.ArrayList;
import java.util.function.Consumer;

public class CounterService {

    private int amountOfCounters;
    private final String ERROR_OF_COUNTER_SEARCH = "There is no counter with this name...";
    private final int RESET_VALUE = 0;
    private ArrayList<Counter> listOfCounters = new ArrayList<Counter>();

    public CounterService(Counter... counters) {
        for (Counter counter : counters) {
            listOfCounters.add(counter);
        }
    }

    public void addCounter(Counter counter) {
        listOfCounters.add(counter);
    }

    public Counter[] getAllCounters() {
        Counter[] countersArray = new Counter[listOfCounters.size()];
        return listOfCounters.toArray(countersArray);
    }

    public Counter getCounterByName(String name) {
        for (Counter counter : listOfCounters) {
            if (counter.getName().equals(name)) {
                return counter;
            }
        }
        System.out.println(ERROR_OF_COUNTER_SEARCH);
        return null;
    }

    public void increment(Counter counter) {
        if (isCounterExist(counter))
            counter.setValue(counter.getValue() + 1);
        else System.out.println(ERROR_OF_COUNTER_SEARCH);
    }

    public void increase(Counter counter, int amount) {
        if (isCounterExist(counter))
            counter.setValue(counter.getValue() + amount);
        else System.out.println(ERROR_OF_COUNTER_SEARCH);
    }

    public void decrease(Counter counter, int amount) {
        if (isCounterExist(counter) && counter.getValue() >= amount)
            counter.setValue(counter.getValue() - amount);
        else System.out.println(ERROR_OF_COUNTER_SEARCH + " or the amount is bigger than counter value");
    }

    public void reset(Counter counter) {
        if (isCounterExist(counter))
            counter.setValue(RESET_VALUE);
    }

    public void decrement(Counter counter) {
        if (isCounterExist(counter))
            counter.setValue(counter.getValue() - 1);
        else System.out.println();
    }

    public void remove(Counter counter){
        listOfCounters.remove(counter);
    }
    public void remove (String name){
        listOfCounters.remove(getCounterByName(name));
    }
    public void remove (int index){
        listOfCounters.remove(index-1);
    }

    public void displayAll(){
        listOfCounters.forEach(new Consumer<Counter>(){
            @Override
            public void accept (Counter counter){
                System.out.printf("%d. %s : %d %s\n",
                        listOfCounters.indexOf(counter)+1,counter.getName(),counter.getValue(),counter.getUnit());
            }
        });
    }

    private boolean isCounterExist(Counter counter) {
        for (Counter someCounter : listOfCounters) {
            if (someCounter.equals(counter))
                return true;
        }
        return false;
    }
}

