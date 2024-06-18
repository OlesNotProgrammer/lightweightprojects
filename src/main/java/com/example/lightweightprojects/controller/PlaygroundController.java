package com.example.lightweightprojects.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.lightweightprojects.entity.Account;
import com.example.lightweightprojects.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/playgournd")
@RequiredArgsConstructor
public class PlaygroundController {
    @Autowired
    private final AccountRepository accountRepository;

    @GetMapping("/account-by-email")
    public ResponseEntity<Optional<Account>> getMethodName(@RequestParam String email) {
        return ResponseEntity.ok(accountRepository.findByEmail(email));
    }
    
}
