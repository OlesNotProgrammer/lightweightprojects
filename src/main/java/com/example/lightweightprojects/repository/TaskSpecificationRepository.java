package com.example.lightweightprojects.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lightweightprojects.entity.TaskSpecification;

public class TaskSpecificationRepository extends JpaRepository<TaskSpecification, Long> {
    
}
