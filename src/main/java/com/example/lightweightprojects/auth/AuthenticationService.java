package com.example.lightweightprojects.auth;

import org.springframework.stereotype.Service;

import com.example.lightweightprojects.auth.model.AuthenticationRequest;
import com.example.lightweightprojects.auth.model.AuthenticationResponce;
import com.example.lightweightprojects.auth.model.RegisterRequest;
import com.example.lightweightprojects.entity.Account;
import com.example.lightweightprojects.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AccountRepository accountRepository;
    private final EncodingAlgorithm encodingAlgorithm;
    private final SessionHandler sessionHandler;

    public AuthenticationResponce register(RegisterRequest request) {
        Account account = Account.builder()
            .login(request.getLogin())
            .password(encodingAlgorithm.encode(request.getPassword(), request.getRegistration()))
            .email(request.getEmail())
            .registration(request.getRegistration())
            .build();
        
        accountRepository.save(account);
        return sessionHandler.generateToken(account);
    }

    public AuthenticationResponce authenticate(AuthenticationRequest request) {
        
    }
}
