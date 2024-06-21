package com.example.lightweightprojects.auth.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponce {
    private String token;
}
