package com.example.lightweightprojects.entity;

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
public class Stage {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stageId;

    @Column
    private String title;
}
