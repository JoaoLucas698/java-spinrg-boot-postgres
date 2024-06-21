/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.exercise.Mapper;

import com.agenda.exercise.DTO.TaskCreateDTO;
import com.agenda.exercise.DTO.TaskResponseDTO;
import com.agenda.exercise.Models.Task;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author joao-lucas
 */
@Component
public class TaskMapper {

    @Autowired
    private ModelMapper mapper;  

    public Task toEntity(TaskCreateDTO dto) {
        Task entity = mapper.map(dto, Task.class);
        return entity;
    }

    public TaskResponseDTO toDto(Task entity) {
        TaskResponseDTO dto = mapper.map(entity, TaskResponseDTO.class);
        return dto;
    }
    
    public List<TaskResponseDTO> toDto(List<Task> tasks){
        return tasks.stream()
                .map(task -> toDto(task))
                .collect(Collectors.toList());
    }
}
