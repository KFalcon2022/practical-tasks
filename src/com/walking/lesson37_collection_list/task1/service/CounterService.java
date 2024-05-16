package com.walking.lesson37_collection_list.task1.service;

import com.walking.lesson37_collection_list.task1.model.Counter;

import java.util.*;

public class CounterService {
    /*// замена ArrayList на Vector не повлияла на кодовую базу, т.к. они оба реализуют интерфейс List,
    // что делает их взаимозаменяемыми
    private final Vector<Counter> counters;

    public CounterService(Counter... counters) {
        this.counters = new Vector<>(Arrays.asList(counters));
    } */

    private final ArrayList<Counter> counters;

    public CounterService(Counter... counters) {
        this.counters = new ArrayList<>(Arrays.asList(counters));
    }

    public List<Counter> getAllCounters() {
        return counters;
    }

    public Counter getFirst() {
        return counters.get(0);
    }

    public void addFirst(Counter counter) {
        counters.add(0, counter);
    }

    public Counter addCounter(Counter counter) {
        counters.add(counter);
        return counters.get(counters.size() - 1);
    }

    public boolean addCountersIfAbsent(Counter... counters) {
        List<Counter> candidates = new ArrayList<>(Arrays.asList(counters));
        candidates.removeAll(this.counters);
        return this.counters.addAll(candidates);
    }

    public boolean removeIfNotMatch(Collection<? extends Counter> sample) {
        return counters.retainAll(sample);
    }

    public boolean removeDuplicates() {
        List<Counter> uniques = getUniques();

        if (uniques.size() == counters.size()) {
            return false;
        }

        counters.clear();
        counters.addAll(uniques);
        return true;
    }

    private List<Counter> getUniques() {
        List<Counter> uniques = new ArrayList<>();

        for (Counter counter : counters) {
            if (!uniques.contains(counter)) {
                uniques.add(counter);
            }
        }

        return uniques;
    }

    public boolean removeAllZeroValue() {
        List<Counter> zeroValues = getZeroValues();

        if (zeroValues.size() == 0) {
            return false;
        }

        counters.removeAll(zeroValues);
        return true;
    }

    private List<Counter> getZeroValues() {
        List<Counter> zeroValues = new ArrayList<>();

        for (Counter counter : counters) {
            if (counter.getValue() == 0) {
                zeroValues.add(counter);
            }
        }

        return zeroValues;
    }

    public void sortByName() {
        counters.sort(Comparator.naturalOrder());
    }

    public void sortBy(Comparator<Counter> comparator) {
        counters.sort(comparator);
    }

    public Counter getCounterByName(String name) {
        for (Counter counter : counters) {
            if (counter.getName().equals(name)) {
                return counter;
            }
        }

        return null;
    }

    public Counter increaseCounter(String name, int value) {
        Counter counter = getCounterByName(name);

        if (counter == null) {
            return null;
        }

        return increaseCounter(counter, value);
    }

    public Counter increaseCounter(Counter counter, int value) {
        counter.setValue(counter.getValue() + value);

        return counter;
    }

    public Counter decreaseCounter(String name, int value) {
        Counter counter = getCounterByName(name);

        if (counter == null) {
            return null;
        }

        return decreaseCounter(counter, value);
    }

    public Counter decreaseCounter(Counter counter, int value) {
        counter.setValue(counter.getValue() - value);

        return counter;
    }

    public Counter incrementCounter(String name) {
        Counter counter = getCounterByName(name);

        if (counter == null) {
            return null;
        }

        return incrementCounter(counter);
    }

    public Counter incrementCounter(Counter counter) {
        increaseCounter(counter, 1);
        return counter;
    }

    public Counter decrementCounter(String name) {
        Counter counter = getCounterByName(name);

        if (counter == null) {
            return null;
        }

        return decrementCounter(counter);
    }

    public Counter decrementCounter(Counter counter) {
        decreaseCounter(counter, 1);
        return counter;
    }

    public Counter reset(String name) {
        Counter counter = getCounterByName(name);

        if (counter == null) {
            return null;
        }

        return reset(counter);
    }

    public Counter reset(Counter counter) {
        counter.setValue(0);

        return counter;
    }

    public void displayContent() {
        System.out.printf("Всего счетчиков: %s\n%s\n", counters.size(), "-".repeat(20));

        if (counters.isEmpty()) {
            System.out.println("Добавьте счетчики для работы с ними.");
        } else {
            printCounterValues();
        }

        System.out.println("-".repeat(20));
    }

    private void printCounterValues() {
        for (Counter counter : counters) {
            System.out.printf("%s: %d %s\n", counter.getName(), counter.getValue(), counter.getUnitOfMeasure());
        }
    }
}
