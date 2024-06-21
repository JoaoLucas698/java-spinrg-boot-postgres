/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.agenda.exercise.Repositry;

import com.agenda.exercise.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author joao-lucas
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
