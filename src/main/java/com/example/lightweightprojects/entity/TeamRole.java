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
public class TeamRole {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamRoleId;

    @Column
    private String label;

    @Column
    private boolean manage_team;

    @Column
    private boolean manage_board;

    @Column
    private boolean consulting;
}
