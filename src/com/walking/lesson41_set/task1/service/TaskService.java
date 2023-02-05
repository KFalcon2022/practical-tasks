package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

public interface TaskService {
    Task add(Task task);

    void complete();
}
