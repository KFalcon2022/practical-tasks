package com.walking.lesson67_locks.task2_1.service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;

import com.walking.lesson67_locks.task2_1.model.Accident;

public class AccidentService {
    private HashMap<Integer, Accident> accidents;
    private ReentrantReadWriteLock locker;

    public AccidentService(){
        this.accidents=new HashMap<>();
        this.locker=new ReentrantReadWriteLock();
    }

    public Accident getAccident(int id){
        try{
            locker.readLock().lock();
            return accidents.get(id);
        } finally{
            locker.readLock().unlock();
        }
    }

    public List<Accident> getAccidents(Predicate<? super Accident> filter){       
        try{
            locker.readLock().lock();
            return accidents.values().stream().filter(filter).toList();
        } finally{
            locker.readLock().unlock();
        }
    }

    public Accident setAccident(Accident accident){
        try{
            locker.writeLock().lock();
            return accidents.put(accident.hashCode(), accident);
        } finally{
            locker.writeLock().unlock();
        }
    }
    
}