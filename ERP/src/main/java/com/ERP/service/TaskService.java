package com.ERP.service;

import com.ERP.entity.Task;
import com.ERP.error.TaskNotFoundException;

import java.util.List;

public interface TaskService {
    public List<Task> fetchTaskList();
    public Task fetchTaskById(int taskId) throws TaskNotFoundException;
    public Task addTask(Task task);
    public void removeTask(int taskId);
    public Task updateTask(int taskId, Task task);
}
