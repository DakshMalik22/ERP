package com.ERP.service;

import com.ERP.entity.Task;
import com.ERP.error.TaskNotFoundException;
import com.ERP.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    void fetchTaskList() {
        Task task1 = Task.builder()
                .name("Add Task Entity")
                .description("Add the Task entity with unit test, services, controller etc")
                .startDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .endDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .status("In Progress")
                .taskId(1)
                .projectId(1)
                .employeeId(1)
                .build();

        Task task2 = Task.builder()
                .name("Add Task Entity")
                .description("Add the Task entity with unit test, services, controller etc")
                .startDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .endDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .status("In Progress")
                .taskId(2)
                .projectId(1)
                .employeeId(1)
                .build();

        List<Task> mockedList = Arrays.asList(task1, task2);

        // Mocking behavior of repository
        when(taskRepository.findAll()).thenReturn(mockedList);

        // Call the method to be tested
        List<Task> result = taskService.fetchTaskList();

        assertSame(mockedList, result); // Assuming you want to check reference equality
        assertEquals(2, result.size()); // Check the size of the returned list
        assertEquals("Add Task Entity", result.get(0).getName()); // Check the first SalaryStructure object
        assertEquals("Add Task Entity", result.get(1).getName()); // Check the second SalaryStructure object
        // Similarly, you can add more assertions to validate other attributes of the SalaryStructure objects
    }

    @Test
    void fetchTaskById() {
        Task task1 = Task.builder()
                .name("Add Task Entity")
                .description("Add the Task entity with unit test, services, controller etc")
                .startDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .endDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .status("In Progress")
                .taskId(1)
                .projectId(1)
                .employeeId(1)
                .build();

        // Mocking behavior of repository
        when(taskRepository.findById(1)).thenReturn(Optional.of(task1));

        try {
            // Call the method to be tested
            Task result = taskService.fetchTaskById(1);
            // Assertions
            assertEquals(task1, result); // Check if the returned optional matches the expected mock optional
        } catch (TaskNotFoundException taskNotFoundException) {
            // Handle the exception or fail the test if necessary
            System.out.println("No Task for this Task Id");
        }


    }

    @Test
    void addTask() {
        // Mock data
        Task task1 = Task.builder()
                .name("Add Task Entity")
                .description("Add the Task entity with unit test, services, controller etc")
                .startDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .endDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .status("In Progress")
                .taskId(1)
                .projectId(1)
                .employeeId(1)
                .build();

        // Mocking behavior of repository
        when(taskRepository.save(any())).thenReturn(task1);

        // Call the method to be tested
        Task addedTask = taskService.addTask(task1);

        // Verify that the repository's save method was called with the correct parameter
        verify(taskRepository).save(task1);

        // Assertions
        assertEquals(task1, addedTask); // Check if the returned object matches the mock object
    }

    @Test
    void removeTask() {
        Task task1 = Task.builder()
                .name("Add Task Entity")
                .description("Add the Task entity with unit test, services, controller etc")
                .startDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .endDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .status("In Progress")
                .taskId(1)
                .projectId(1)
                .employeeId(1)
                .build();


        // Mocking behavior of repository
        when(taskRepository.findById(1)).thenReturn(Optional.of(task1));

        // Call the method to be tested
        taskService.removeTask(1);

        // Verify that the repository's deleteById method was called with the correct parameter
        verify(taskRepository).deleteById(1);
    }

    @Test
    void updateTask() {
        Task taskExisting = Task.builder()
                .name("Add Task Entity")
                .description("Add the Task entity with unit test, services, controller etc")
                .startDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .endDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .status("In Progress")
                .taskId(1)
                .projectId(1)
                .employeeId(1)
                .build();

        Task taskUpdated = Task.builder()
                .name("Task Entity")
                .description("empty")
                .startDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .endDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .status("Complete")
                .taskId(1)
                .projectId(2)
                .employeeId(3)
                .build();

        // Mocking behavior of repository
        when(taskRepository.findById(1)).thenReturn(Optional.of(taskExisting));
        when(taskRepository.save(taskUpdated)).thenReturn(taskUpdated);

        // Call the method to be tested
        taskService.updateTask(1, taskUpdated);

        // Verify that the repository's findById and save methods were called with the correct parameters
        verify(taskRepository).findById(1);
        verify(taskRepository).save(taskUpdated);
    }
}