package com.ERP.controller;

import com.ERP.entity.Task;
import com.ERP.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @MockBean
    TaskService taskService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getTask() throws Exception {
        Task task1 = Task.builder()
                .name("Task Entity")
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

        List<Task> taskList = Arrays.asList(task1, task2);

        when(taskService.fetchTaskList()).thenReturn(taskList);
        mockMvc.perform(get("/task")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Task Entity"));

    }

    @Test
    void addTask() throws Exception {
        Task task = Task.builder()
                .taskId(1)
                .name("Task Entity")
                .description("Add the Task entity with unit test, services, controller etc")
                .startDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .endDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .status("In Progress")
                .projectId(1)
                .employeeId(1)
                .build();

        when(taskService.addTask(task)).thenReturn(task);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        mockMvc.perform(post("/addTask")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk());
    }

    @Test
    void getTaskById() throws Exception {
        Task task = Task.builder()
                .taskId(1)
                .name("Task Entity")
                .description("Add the Task entity with unit test, services, controller etc")
                .startDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .endDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .status("In Progress")
                .projectId(1)
                .employeeId(1)
                .build();

        when(taskService.fetchTaskById(1)).thenReturn(task);

        mockMvc.perform(get("/task/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Task Entity"));
    }

    @Test
    void removeTask() throws Exception {
        Task task = Task.builder()
                .taskId(1)
                .name("Task Entity")
                .description("Add the Task entity with unit test, services, controller etc")
                .startDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .endDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .status("In Progress")
                .projectId(1)
                .employeeId(1)
                .build();

        doNothing().when(taskService).removeTask(1);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        mockMvc.perform(delete("/removeTask/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk());
    }

    @Test
    void updateTask() throws Exception {
        Task existingTask = Task.builder()
                .taskId(1)
                .name("Task Entity")
                .description("Add the Task entity with unit test, services, controller etc")
                .startDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .endDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .status("In Progress")
                .projectId(1)
                .employeeId(1)
                .build();

        Task updatedTask = Task.builder()
                .taskId(1)
                .name("The Task Entity")
                .description("Add the Task entity with unit test, services, controller etc")
                .startDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .endDate(LocalDateTime.parse("2024-04-29T09:00:00"))
                .status("InComplete")
                .projectId(1)
                .employeeId(1)
                .build();

        // Mock the service behavior to update the Task
        when(taskService.updateTask(eq(1), any(Task.class)))
                .thenReturn(updatedTask);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        // Perform PUT request to update the salary structure
        mockMvc.perform(put("/updateTask/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedTask)))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("The Task Entity"));
                .andExpect(jsonPath("$.status").value("InComplete"));
    }

}