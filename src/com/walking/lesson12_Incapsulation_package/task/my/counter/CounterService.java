package com.walking.lesson12_Incapsulation_package.task.my.counter;

public class CounterService {
    private static Counter[] objects;
    int i;

    public CounterService(Counter... counters) {
        objects = new Counter[counters.length];
        i = 0;
        for (Counter x : counters) {
            objects[i] = x;
            i++;
        }
    }

    public void getObjects() {
        System.out.println(getObjects(objects));
    }

    private String getObjects(Counter[] objects) {
        String counterInfo = "";

        for (Counter x : objects) {
            counterInfo += x.getName() + ": ";
            counterInfo += x.getCounter() + " ";
            counterInfo += x.getMeasuringUnit() + "\n";
        }
        return counterInfo;
    }

    public void getOneObject(String name) {
        System.out.println(getOneObject(name, objects));
    }

    private String getOneObject(String name, Counter[] objects) {
        String counterInfo = "";

        for (Counter x : objects) {
            if (name == x.getName()) {
                counterInfo += x.getName() + "\t";
                counterInfo += x.getCounter() + " ";
                counterInfo += x.getMeasuringUnit() + "\n";
            }
        }
        return counterInfo;
    }

    public void increment(String name) {
        increment(name, objects);
    }

    private void increment(String name, Counter[] objects) {
        for (Counter x : objects) {
            if (name == x.getName()) {
                x.increment();
                // increment(x);
                break;
            }
        }
    }

//    private void increment(Counter counter) {
//        ++counter.counter;
//    }

    public void increase(String name, int value) {
        increase(name, value, objects);
    }

    private void increase(String name, int value, Counter[] objects) {
        for (Counter x : objects) {
            if (name == x.getName()) {
                x.increase(value);//increase(x, value);

                break;
            }
        }
    }

//    private void increase(Counter counter, int value) {
//        counter.counter += value;
//    }

    public void reset(String name) {
        reset(name, objects);
    }

    private void reset(String name, Counter[] objects) {
        for (Counter x : objects) {
            if (name == x.getName()) {
                x.reset(); // reset(x);
                break;
            }
        }
    }

//    private void reset(Counter counter) {
//        counter.counter = 0;
//    }
}

//Все что в комментариях - первоначальная версия
//В ней не было методов increment, increase и reset в классе Counter)