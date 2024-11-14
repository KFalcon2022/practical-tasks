package com.walking.lesson73_barrier.task1;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Эмулируйте сбор компании друзей в цикле.
 * <p>
 * Есть 10 друзей-потоков. Они должны собраться вместе (преодолеть) турникет.
 * Каждый из потоков имеет предел терпения, он же, время ожидание,
 * определенный в случайном порядке.
 * Также каждый из них имеет случайно определенную степень безответственности,
 * выражающуюся в задержке перед сбором.
 * <p>
 * Попробуйте собрать друзей, используя в качестве каждой попытки итерацию цикла.
 * Если хоть один из друзей не вытерпел и покинул место сбора – сбор должен провалиться.
 * <p>
 * С какой попытки друзьям удалось собраться?
 * <p>
 * Верхние и нижние границы терпения и безответственности определите самостоятельно.
 */
public class Main {
    public static void main(String[] args) {
        AtomicBoolean done=new AtomicBoolean(false);
        CyclicBarrier barrier=new CyclicBarrier(10, ()->{done.set(true); System.out.println("Finally!");});
        Runnable friend=()->{
            try {
                int number=getNumber(10);
                System.out.println(Thread.currentThread().getName()+": собираюсь:"+number);
                Thread.sleep(number*1000);
                number=getNumber(10);
                System.out.println(Thread.currentThread().getName()+": жду:"+number);
                barrier.await(getNumber(10), TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                
            } catch (BrokenBarrierException e) {

            } catch (TimeoutException e) {
                System.out.println(Thread.currentThread().getName()+" не дождался");
                System.out.println("_______________");
                Thread.currentThread().getThreadGroup().interrupt();
            }
        };
        int times=0;
        while (!done.get()) {
            ThreadGroup group=new ThreadGroup("Friends");
            ArrayList<Thread> friends=new ArrayList<>(10);
            friends.add(new Thread(group, friend, "Вася"));
            friends.add(new Thread(group, friend, "Петя"));
            friends.add(new Thread(group, friend, "Саша"));
            friends.add(new Thread(group, friend, "Володя"));
            friends.add(new Thread(group, friend, "Леша"));
            friends.add(new Thread(group, friend, "Сережа"));
            friends.add(new Thread(group, friend, "Игорь"));
            friends.add(new Thread(group, friend, "Олег"));
            friends.add(new Thread(group, friend, "Иван"));
            friends.add(new Thread(group, friend, "Дима"));
            friends.stream().forEach(Thread::start);
            while(group.activeCount()>0){

            }
            barrier.reset();
            times++;
        }
        System.out.println(times);
    }
    private static int getNumber(int max){
        int random=(int)Math.round(Math.random()*max);
        return (random==0)?1:random;
    }
}