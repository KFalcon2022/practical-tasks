package com.walking.lesson67_locks.task2_2.service;

import com.walking.lesson67_locks.task2_2.model.Accident;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccidentService {
    private final Map<Long, Accident> accidents = new HashMap<>();
    //    В целом, даже в текущем условии не было бы проблемы в использовании ReadWriteLock.
//    Но в качестве демонстрации используем обычный ReentrantLock
    private final Lock lock = new ReentrantLock();

    public Accident getById(long id) {
        try {
            lock.lock();
            return accidents.get(id);
        } finally {
            lock.unlock();
        }
    }

    public List<Accident> getByIds(Collection<Long> ids) {
        try {
            lock.lock();

            return ids.stream()
                    .map(accidents::get)
                    .filter(Objects::nonNull)
                    .toList();
        } finally {
            lock.unlock();
        }
    }

    public Accident createOrUpdate(Accident accident) {
        try {
            lock.lock();

            accidents.compute(
                    accident.getId(),
                    (k, v) -> v == null || v.getUpdated().isBefore(accident.getUpdated()) ? accident : v);

//            Обратите внимание: ReentrantLock позволяет "занять" lock повторно потоку,
//            который его уже занял к этому моменту
            return getById(accident.getId());
        } finally {
            lock.unlock();
        }
    }
}
