/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.exercise.Controller;

import com.agenda.exercise.DTO.TaskCreateDTO;
import com.agenda.exercise.DTO.TaskResponseDTO;
import com.agenda.exercise.Exception.TaskNotFoundException;
import com.agenda.exercise.Mapper.TaskMapper;
import com.agenda.exercise.Models.Task;
import com.agenda.exercise.Services.TaskService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joao-lucas
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskMapper taskMapper;

    @GetMapping("/all")
    public ResponseEntity<List<TaskResponseDTO>> allTasks() {
        List<Task> tasks = taskService.getAllTasks();
        List<TaskResponseDTO> result = taskMapper.toDto(tasks);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> taskById(@PathVariable(value = "id") Long id) {
        try {
            Task task = taskService.getTaskById(id);
            TaskResponseDTO result = taskMapper.toDto(task);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (TaskNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<TaskResponseDTO> postTask(@RequestBody TaskCreateDTO taskCreateDTO) {
        Task task = taskService.createTask(taskMapper.toEntity(taskCreateDTO));
        TaskResponseDTO result = taskMapper.toDto(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable(value = "id") Long id, @RequestBody TaskCreateDTO taskCreateDTO) {
        try {
            Task task = taskService.updateTask(id, taskMapper.toEntity(taskCreateDTO));
            TaskResponseDTO result = taskMapper.toDto(task);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (TaskNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") Long id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.status(HttpStatus.OK).body("Task successfully deleted");
        } catch (TaskNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }
}
