package com.example.lightweightprojects.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lightweightprojects.entity.Team;

public class TeamRepository extends JpaRepository<Team, Long> {
    
}
