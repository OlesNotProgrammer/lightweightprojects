package com.example.lightweightprojects.auth.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    private String login;
    private String password;
    private String email;
    private Date registrationDate;
}
