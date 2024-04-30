package com.ERP.controller;

import com.ERP.entity.Task;
import com.ERP.error.TaskNotFoundException;
import com.ERP.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public List<Task> getHR(){
        return taskService.fetchTaskList();
    }

    @PostMapping("/addTask")
    public Task addHR(@Valid @RequestBody Task task){
        return taskService.addTask(task);
    }

    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable("id") int taskId) throws TaskNotFoundException {
        return taskService.fetchTaskById(taskId);
    }

    @DeleteMapping("/removeTask/{id}")
    public void removeTask(@PathVariable("id") int taskId){
        taskService.removeTask(taskId);
    }

    @PutMapping("/updateTask/{id}")
    public Task updateHR(@PathVariable("id") int taskId,
                       @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }
}
