package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.*;

public class TaskService {
    private final TreeSet<Task> taskQueue = new TreeSet<>();

    public void addTask(Task task) {
        taskQueue.add(task);
        System.out.printf("Задание %S добавлено\n", task.getName());
    }

    public boolean getTaskQuestion(){
        if (!taskQueue.isEmpty()) {
            System.out.printf("Сколько будет: %s\n", taskQueue.first().getQuestion());
            return true;
        } else {
            System.out.println("Задание отсутствует");
            return false;
        }
    }

    private void completeTask (int answer) {
        Task task = taskQueue.pollFirst();


            if (task.getAnswer() == (answer)) {
                System.out.printf("Задание %s выполнено\n", task.getName());
            } else {
                taskQueue.add(new Task(task));
                System.out.printf("Задание %s возвращено на доработку\n", task.getName());
            }

    }

    public void answerTask() {
        Scanner scanner = new Scanner(System.in);

        int answer;

        while (getTaskQuestion()) {
            answer = scanner.nextInt();

            completeTask(answer);
        }

        scanner.close();
    }
}
