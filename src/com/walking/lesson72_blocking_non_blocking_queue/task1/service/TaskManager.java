package com.walking.lesson72_blocking_non_blocking_queue.task1.service;

import java.util.concurrent.LinkedBlockingQueue;

import com.walking.lesson72_blocking_non_blocking_queue.task1.model.Task;

public class TaskManager {
    LinkedBlockingQueue<Task> queue=new LinkedBlockingQueue<>();

    public void addTask(String name, String description, String term) throws InterruptedException{
        queue.put(new Task(name, description, term));
        System.out.println("Успешно добавлено задание: "+name);
    }
    
    public boolean completeTask() throws InterruptedException{
        if (queue.size()==0){
            System.out.println("Заданий нет");
            return false;
        }
        Task temp=queue.take();
        if (temp.late()){
            System.out.println("С опозданием выполнено задание: "+temp.name);
        } else {
            System.out.println("Вовремя выполнено задание: "+temp.name);
        }
        return true;
    }

    public String getNextTask(){
        if (queue.size()==0)
            return "Заданий нет";
        StringBuilder task=new StringBuilder(queue.peek().name+"\n");
        task.append(queue.peek().description+"\n");
        task.append("Срок до "+queue.peek().term.toString());
        return task.toString();
        
    }
}
