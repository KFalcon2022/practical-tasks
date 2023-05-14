package com.walking.lesson73_barrier.task1;

import com.walking.lesson73_barrier.task1.model.Friend;
import com.walking.lesson73_barrier.task1.service.IntRandomGenerator;

import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
    public static void main(String[] args) throws InterruptedException {
        var randomGenerator = new IntRandomGenerator(1, 5);
        var barrier = new CyclicBarrier(10, () -> System.out.println("Gather is successful!"));

        Stream.generate(() -> tryGather(randomGenerator, barrier))
                .takeWhile(success -> !success)
                .forEach(s -> System.out.println("Gather is failed."));
    }

    private static boolean tryGather(IntRandomGenerator randomGenerator, CyclicBarrier barrier) {
        System.out.println("Let's try!");

        return IntStream.range(0, 10)
                .boxed()
                .map(i -> getFriend(randomGenerator, barrier))
                .map(Thread::new)
                .peek(Thread::start)
//                    Поскольку стрим выполняется в одном потоке,
//                    если в нем вызвать Thread#start() и Thread#join() -
//                    получится, что каждый стрим будет вызываться, выполняться,
//                    а лишь затем - запускаться следующий
                .toList()
                .stream()
                .allMatch(Main::isCompleted);
    }

    private static Friend getFriend(IntRandomGenerator randomGenerator, CyclicBarrier barrier) {
        return new Friend(randomGenerator.generate(), randomGenerator.generate(), barrier);
    }

    private static boolean isCompleted(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            return false;
        }

        return !thread.isInterrupted();
    }
}