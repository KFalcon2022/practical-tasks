package lesson12_incapsulation.com.walking.counterAggregation;

public class CounterService {
    Counter[] counters = new Counter[4];

    Counter[] getAllCounters() {
        return counters;
    }

    void initCounters(Counter[] counters) {
        this.counters = counters;
    }

    Counter getCounterByName(String name) {
        for (Counter counter : this.getAllCounters()) {
            if (counter.getName().equals(name)) {
                return counter;
            }
        }
        return null;
    }

    int increase(String name, int value) {
        Counter counter = getCounterByName(name);
        counter.setCounter(counter.getCounter() + value);

        return counter.getCounter();
    }

    int decrease(String name, int value) {
        Counter counter = getCounterByName(name);
        counter.setCounter(counter.getCounter() - value);

        return counter.getCounter();
    }

    int increment(String name) {
        Counter counter = getCounterByName(name);
        counter.setCounter(counter.getCounter() + 1);

        return counter.getCounter();
    }

    int decrement(String name) {
        Counter counter = getCounterByName(name);
        counter.setCounter(counter.getCounter() - 1);

        return counter.getCounter();
    }

    int reset(String name) {
        getCounterByName(name).setCounter(0);
        return 0;
    }
}