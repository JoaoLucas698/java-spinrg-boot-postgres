/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.exercise.DTO;

import java.util.Date;

/**
 *
 * @author joao-lucas
 */
public class TaskResponseDTO {

    private Long id;
    private String title;
    private String description;
    private Date endTaskDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
