package com.walking.lesson67_locks.task2_1.service;

import com.walking.lesson67_locks.task2_1.model.Accident;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AccidentService {
    private final Map<Long, Accident> accidents = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public Accident getById(long id) {
        try {
            lock.readLock().lock();
            return accidents.get(id);
        } finally {
            lock.readLock().unlock();
        }
    }

    public Accident createOrUpdate(Accident accident) {
        try {
            lock.writeLock().lock();

            accidents.compute(
                    accident.getId(),
                    (k, v) -> v == null || v.getUpdated().isBefore(accident.getUpdated()) ? accident : v);

//            Обратите внимание: можно внутри активного writeLock "занять" readLock. Наоборот - нельзя
            return getById(accident.getId());
        } finally {
            lock.writeLock().unlock();
        }
    }
}
