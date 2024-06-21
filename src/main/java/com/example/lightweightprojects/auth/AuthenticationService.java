package com.example.lightweightprojects.auth;

import org.springframework.stereotype.Service;

import com.example.lightweightprojects.auth.model.AuthenticationRequest;
import com.example.lightweightprojects.auth.model.AuthenticationResponce;
import com.example.lightweightprojects.auth.model.RegisterRequest;
import com.example.lightweightprojects.auth.model.ValidateResponce;
import com.example.lightweightprojects.entity.Account;
import com.example.lightweightprojects.repository.AccountRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private SessionService sessionService;
    private AccountRepository accountRepository;

    public AuthenticationResponce register(RegisterRequest request) {
        // Account account = Account.builder()
        //     .login(request.getLogin())
        //     .password(sessionService.encode(request.getPassword(), request.getRegistrationDate()))
        //     .email(request.getEmail())
        //     .registrationDate(request.getRegistrationDate())
        //     .build();
        
            System.out.println(request.getEmail());
        // accountRepository.save(account);

        // return AuthenticationResponce.builder()
        //     .token(sessionService.generateSessionToken(account))
        //     .build();

        return AuthenticationResponce.builder()
            .token("1234543453")
            .build();
        
    }

    public AuthenticationResponce authenticate(AuthenticationRequest request) {
        Account account = accountRepository
            .findByEmail(request.getEmail())
            .orElseThrow();

        return AuthenticationResponce.builder()
            .token(sessionService.generateSessionToken(account))
            .build();
    }

    public void logout(HttpServletRequest request) {
        sessionService.closeSession(extractToken(request));
    }

    public ValidateResponce validateToken(HttpServletRequest request) {
        return ValidateResponce.builder()
            .status(sessionService.isActiveSession(extractToken(request)))
            .build();
    }

    private String extractToken(HttpServletRequest request) {
        String authHeader = request.getHeader("AuthenticationToken");
        String authToken = "Bearer ";

        if (authHeader == null || !authHeader.startsWith(authToken)) {
            return null;
        }

        return authHeader.substring(authToken.length());
    }
}
