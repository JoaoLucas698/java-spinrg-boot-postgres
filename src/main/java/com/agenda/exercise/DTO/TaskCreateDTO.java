/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.exercise.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

/**
 *
 * @author joao-lucas
 */
public class TaskCreateDTO {

    @NotBlank(message = "A tarefa deve ter um titulo")
    private String title;

    @NotBlank(message = "A tarefa deve ter uma descrição")
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotBlank(message = "A tarefa deve ter uma data de termino")
    private Date endTaskDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndTaskDate() {
        return endTaskDate;
    }

    public void setEndTaskDate(Date endTaskDate) {
        this.endTaskDate = endTaskDate;
    }

}
