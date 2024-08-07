package com.walking.lesson40_queue2.service;

import com.walking.lesson39_queue1.task4.model.Queue;
import com.walking.lesson40_queue2.model.Task;

public class TaskManager {
    Queue<Task> queue=new Queue<>();

    public void addTask(String name, String description, String term){
        queue.offer(new Task(name, description, term));
        System.out.println("Успешно добавлено задание: "+name);
    }
    
    public void completeTask(){
        if (queue.size()==0){
            System.out.println("Заданий нет");
            return;
        }
        Task temp=queue.poll();
        if (temp.late()){
            System.out.println("С опозданием выполнено задание: "+temp.name);
        } else {
            System.out.println("Вовремя выполнено задание: "+temp.name);
        }
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
