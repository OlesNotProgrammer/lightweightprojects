package com.example.lightweightprojects.auth;

import java.util.Date;
import java.util.HashMap;
 
import org.springframework.stereotype.Service;

import com.example.lightweightprojects.entity.Account;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionHandler {
    private final long tokenLifetime = 1000 * 60 * 24;
    private final HashMap<String, Date> sessions;
    private final EncodingAlgorithm encodingAlgorithm;

    public String generateToken(Account account) {
        Date deadlock = new Date(System.currentTimeMillis() + tokenLifetime);

        return encodingAlgorithm.encode(account.getEmail(), deadlock);
    }

    public boolean isTokenValid(String token) {
        if (sessions.containsKey(token)) {
            return sessions.get(token).before(new Date());
        }

        return false;
    }
}
