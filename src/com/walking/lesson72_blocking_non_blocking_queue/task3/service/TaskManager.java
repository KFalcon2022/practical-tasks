package com.walking.lesson72_blocking_non_blocking_queue.task3.service;

import java.util.concurrent.LinkedBlockingQueue;

import com.walking.lesson72_blocking_non_blocking_queue.task3.model.Task;

public class TaskManager {
    LinkedBlockingQueue<Task> queue=new LinkedBlockingQueue<>(10);

    public void addTask(int boarder) throws InterruptedException{
        int number=getNumber(boarder);
        queue.put(new Task(number));
        System.out.println("Успешно добавлено задание: "+number);
    }
    
    public Task completeTask() throws InterruptedException{
        return queue.take();
    }

    public Task getNextTask(){
        return queue.peek();
    }

    private int getNumber(int max){
        int random=(int)Math.round(Math.random()*max);
        return (random==0)?1:random;
    }
    
}
