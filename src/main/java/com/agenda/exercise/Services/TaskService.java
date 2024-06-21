/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.exercise.Services;

import com.agenda.exercise.Exception.TaskNotFoundException;
import com.agenda.exercise.Models.Task;
import com.agenda.exercise.Repositry.TaskRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author joao-lucas
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        try {
            return taskRepository.save(task);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) throws TaskNotFoundException {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        } else {
            throw new TaskNotFoundException("Task id: " + id + " not Found");
        }

    }

    public Task updateTask(Long id, Task updatedTask) throws TaskNotFoundException {
        Task task = getTaskById(id);
        task.setDescription(updatedTask.getDescription());
        task.setTitle(updatedTask.getTitle());
        task.setEndTaskDate(updatedTask.getEndTaskDate());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) throws TaskNotFoundException {
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }
}
