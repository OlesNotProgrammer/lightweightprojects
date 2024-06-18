package com.example.lightweightprojects.auth;

import java.util.Date;
import java.util.HashMap;
import java.util.NoSuchElementException;

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
    private final SessionHandler sessionHandler;
    private final EncodingAlgorithm encodingAlgorithm;

    public boolean register(RegisterRequest request) {
        Account account = Account.builder()
            .login(request.getLogin())
            .password(encodingAlgorithm.encode(request.getPassword(), request.getRegistration()))
            .email(request.getEmail())
            .registration(request.getRegistration())
            .build();
        
        accountRepository.save(account);
        return true;
    }

    public AuthenticationResponce authenticate(AuthenticationRequest request) throws NoSuchElementException {
        Account account = accountRepository
            .findByEmail(request.getEmail())
            .orElseThrow();


        return null;
    }
}
