package com.walking.lesson65_atomics.task1.service;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterService {
    private HashMap<String,AtomicInteger> storage;

    public CounterService(){
        this.storage=new HashMap<>();
    }

    public synchronized int addCounter(String name){
        if (storage.containsKey(name))
        {
            return getValue(name);
        } else {
            storage.put(name, new AtomicInteger());
            return getValue(name);
        }
    }

    public synchronized int delCounter(String name){
        if (storage.containsKey(name)) {
            
            return storage.remove(name).get();
        } else {
            return 0;
        }
    }

    private synchronized AtomicInteger getCounter(String name){
        if (!storage.containsKey(name)) {
            storage.put(name, new AtomicInteger());
        }
        return storage.get(name);
    }

    public int addValue(String name, int value){
        var counter=getCounter(name);
        return counter.addAndGet(value);
    }

    public void resetCounter(String name){
        getCounter(name).set(0);

    }

    public int getValue(String name){
        var counter=getCounter(name);
        return counter.get();
    }
}