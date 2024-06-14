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
public class BoardTask {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardTaskId;

    @Column
    private Date duration;

    @Column
    private Date starting;

    @Column
    private Date ending;
}
