package com.walking.lesson67_locks.task2_2.service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

import com.walking.lesson67_locks.task2_1.model.Accident;

public class AccidentService {
    private HashMap<Integer, Accident> accidents;
    private ReentrantLock locker;

    public AccidentService(){
        this.accidents=new HashMap<>();
        this.locker=new ReentrantLock();
    }

    public Accident getAccident(int id){       
        try{
            locker.lock();
            return accidents.get(id);
        } finally{
            locker.unlock();
        }
    }

    public List<Accident> getAccidents(Predicate<? super Accident> filter){       
        try{
            locker.lock();
            return accidents.values().stream().filter(filter).toList();
        } finally{
            locker.unlock();
        }
    }

    public Accident setAccident(Accident accident){
        try{
            locker.lock();
            return accidents.put(accident.hashCode(), accident);
        } finally{
            locker.unlock();
        }
    }
    
}