package com.example.lightweightprojects.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TaskSpecification {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TaskSpecificationId;

    @Column
    private Date registration;

    @Column
    private String value;
}
