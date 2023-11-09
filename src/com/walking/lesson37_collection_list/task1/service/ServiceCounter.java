package com.walking.lesson37_collection_list.task1.service;

import com.walking.lesson37_collection_list.task1.model.Counter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class ServiceCounter {

    private List<Counter> counters;

    //private Vector<Counter> counters;

    public ServiceCounter (Counter counter) {
        this.counters = new ArrayList<>((Collection) counter);
        //counters = new Vector<>((Collection) counter);
    }

    public ServiceCounter(List<Counter> counters) {
        this.counters = new ArrayList<>(counters);
        // this.counters = new Vector<>(counters);
    }

    public void add(Counter counter) {
        counters.add(counter);
    }

    public List<Counter> getAll() {
        return counters;
    }

    public Counter getCounter (String name) {
        for(Counter counter : counters) {
            if (counter.getName().equals(name)) {
                return counter;
            }
        }

        return null;
    }

    public Counter increaceValue (String name) {

        return increaceValue(name,1);
    }

    public Counter increaceValue (String name, int value) {
        Counter counter = getCounter(name);

        counter.setValue(counter.getValue() + value);

        return counter;
    }

    public Counter decreaceValue(String name, int value) {
        Counter counter = getCounter(name);

        counter.setValue(counter.getValue() - value);

        return counter;
    }

    public Counter decreaceValue(String name) {
        return decreaceValue(name,1);
    }

    public Counter reset(String name) {
        Counter counter = getCounter(name);

        if (counter == null) {
            return null;
        }

        return reset(counter);
    }

    public Counter reset(Counter counter) {
        counter.setValue(0);

        return counter;
    }
}
