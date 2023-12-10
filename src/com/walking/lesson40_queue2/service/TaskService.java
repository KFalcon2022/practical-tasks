package com.walking.lesson40_queue2.service;

import com.walking.lesson40_queue2.models.Task;

import java.util.PriorityQueue;

public class TaskService {
    private final PriorityQueue queue;
    public TaskService(){
        queue=new PriorityQueue<>();
    }
    public TaskService(Task ...task){
        this();
        add(task);
    }
    public void add(Task ...task){
        for (Task t : task){
            queue.offer(t);
            System.out.println("Task "+t.getNAME()+" (ID) "+t.getID()+" added. Time "+t.getTIME_OF_CREATION());
        }
    }
    public void perform(){
        while (queue.peek()!=null){
            Task temp = (Task) queue.poll();
            System.out.println("Task "+temp.getNAME()+" (ID) "+temp.getID()+" complete. Time "+temp.getTIME_OF_CREATION());
        }
    }

}
