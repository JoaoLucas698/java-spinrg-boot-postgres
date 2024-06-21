/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.exercise.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author joao-lucas
 */
@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "endTaskDate", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date endTaskDate;

//    public Task() {
//    }
//
//    public Task(Long id, String title, String description, Date endTaskDate) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.endTaskDate = endTaskDate;
//    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEndTaskDate(Date endTaskDate) {
        this.endTaskDate = endTaskDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getEndTaskDate() {
        return endTaskDate;
    }

//    @Override
//    public String toString() {
//        return "Task{"
//                + "id=" + id
//                + ", title='" + title + '\''
//                + ", description='" + description + '\''
//                + ", endTaskDate=" + endTaskDate
//                + '}';
//    }
}
