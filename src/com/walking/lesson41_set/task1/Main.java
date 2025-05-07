package com.walking.lesson41_set.task1;

import com.walking.lesson41_set.task1.model.Task;
import com.walking.lesson41_set.task1.service.TaskService;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson40_queue2">...</a>,
 * используя Set, вместо Queue.
 * Продумайте, как можно эффективно реализовать задачу,
 * чтобы сохранить принцип FIFO при обработке заданий.
 */
public class Main {
    public static void main(String[] args) {
        Task stepForward = new Task("Step Forward");
        Task stepBack = new Task("Step Back");
        Task turnLeft = new Task("Turn left");
        Task turnRight = new Task("Turn right");
        Task turnAround = new Task("Turn around");

        TaskService tasks = new TaskService();

        tasks.add(stepForward);
        tasks.add(stepBack);
        tasks.add(turnLeft);
        tasks.add(turnRight);
        tasks.add(turnAround);

        while(!tasks.getTasks().isEmpty()) {
            tasks.perform();
        }
    }
}
