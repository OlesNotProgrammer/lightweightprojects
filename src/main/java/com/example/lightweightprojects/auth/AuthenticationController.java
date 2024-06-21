package com.example.lightweightprojects.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lightweightprojects.auth.model.AuthenticationRequest;
import com.example.lightweightprojects.auth.model.AuthenticationResponce;
import com.example.lightweightprojects.auth.model.RegisterRequest;
import com.example.lightweightprojects.auth.model.ValidateResponce;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/authentication")
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public AuthenticationResponce register(@RequestBody RegisterRequest request) {
        return authenticationService.register(request);
    }

    @PostMapping("/authenticate")
    public AuthenticationResponce authenticate(AuthenticationRequest request) {
        return authenticationService.authenticate(request);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {

    }

    @GetMapping("/validateToken")
    public ValidateResponce validateToken(HttpServletRequest request) {
        return authenticationService.validateToken(request);
    }
}
