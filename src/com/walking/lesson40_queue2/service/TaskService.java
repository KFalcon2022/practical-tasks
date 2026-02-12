package com.walking.lesson40_queue2.service;

import com.walking.lesson40_queue2.model.Task;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class TaskService {
    private final Queue<Task> taskQueue = new ArrayDeque<>();

    public void addTask(Task task) {
        taskQueue.offer(task);
        System.out.println("Задание добавлено");
    }

    public boolean getTaskQuestion(){
        if (taskQueue.peek() != null) {
            System.out.printf("Сколько будет: %s\n", taskQueue.peek().getQuestion());
            return true;
        } else {
            System.out.println("Задание отсутствует");
            return false;
        }
    }

    private void completeTask (int answer) {
        Task task = taskQueue.poll();


            if (task.getAnswer() == (answer)) {
                System.out.printf("Задание %s выполнено\n", task.getName());
            } else {
                taskQueue.offer(task);
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
