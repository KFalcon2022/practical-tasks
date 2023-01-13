package com.walking.lesson37.Task1;

import java.util.ArrayList;
import java.util.List;

public class CounterService {
    public final List<Counter> data;

    public CounterService() {
        data = new ArrayList<Counter>();
    }

    public CounterService add(Counter counter) {
        data.add(counter);
        return this;
    }

    public CounterService insert(int position, Counter counter) {
        position = Math.max(0, Math.min(data.size(), position));
        data.add(position, counter);
        return this;
    }

    public void remove(Counter counter) {
        data.remove(counter);
    }

    public void remove(String name) {
        Counter test = findCounter(name);
            if(test !=null) {
                remove(test);
            }
    }

    public Counter getCounter(int position) {
        position = Math.max(0, Math.min(data.size(), position));
        return data.get(position);
    }

    public Counter findCounter(String name) {
        for (Counter c : data){
            if (c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public void incValue(String name, double value){
        Counter test =  findCounter(name);
        if (test != null){
            test.setValue(test.getValue() + value);
        }
    }

    public void incValue(String name){
        incValue(name, 1.0);
    }

    public List<Counter> getCounters() {
        return data;
    }

    public void clear(String name){
        Counter test =  findCounter(name);
        if (test != null){
            test.setValue(0);
        }
    }

    public void printCounters() {
        for (Counter c : getCounters()) {
            System.out.println(c);
        }
        System.out.println("");
    }
}
