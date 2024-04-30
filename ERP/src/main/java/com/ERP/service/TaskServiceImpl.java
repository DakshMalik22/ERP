package com.ERP.service;

import com.ERP.entity.Task;
import com.ERP.error.TaskNotFoundException;
import com.ERP.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Task> fetchTaskList(){
        return taskRepository.findAll();
    }

    @Override
    public Task fetchTaskById(int taskId) throws TaskNotFoundException {
        Optional<Task> task = taskRepository.findById(taskId);
        if(!task.isPresent()){
            throw new TaskNotFoundException("Task Not Available");
        }
        return task.get();
    }
    @Override
    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    @Override
    public void removeTask(int taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task updateTask(int taskId, Task task) {
        Task task1 = taskRepository.findById(taskId).get();

        if(Objects.nonNull(task.getName()) &&
                !"".equalsIgnoreCase(task.getName())){
            task1.setName(task.getName());
        }

        if(Objects.nonNull(task.getDescription()) &&
                !"".equalsIgnoreCase(task.getDescription())){
            task1.setDescription(task.getDescription());
        }

        if(Objects.nonNull(task.getStartDate()) &&
                !"".equals(task.getStartDate())){
            task1.setStartDate(task.getStartDate());
        }

        if(Objects.nonNull(task.getEndDate()) &&
                !"".equals(task.getEndDate())){
            task1.setEndDate(task.getEndDate());
        }

        if(Objects.nonNull(task.getStatus()) &&
                !"".equals(task.getStatus())){
            task1.setStatus(task.getStatus());
        }

        if (Objects.nonNull(task.getProjectId()) && task.getProjectId() != 0) {
            task1.setProjectId(task.getProjectId());
        }
        if (Objects.nonNull(task.getEmployeeId()) && task.getEmployeeId() != 0) {
            task1.setEmployeeId(task.getEmployeeId());
        }

        return taskRepository.save(task1);
    }
}
