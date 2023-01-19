package com.walking.lesson40.Task1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class TaskQueue {
    private final Queue<Task> queue;

    public TaskQueue(){
        queue = new ArrayDeque();
    }

    public boolean add(Task task){
        boolean result = queue.offer(task);
        if (result) {
            System.out.println(task.getName() + " added");
        }
        return result;
    }

    public void run(){
        Task task = queue.poll();
        if (task != null) {
            System.out.println(task.getName() + " executed");
        }
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
