package com.example.lightweightprojects.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class TaskSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_specification_id")
    private long id;
    
    private long task;
    private long creator;
    private long target;
    private Date registration;
    private String text;
}
