package com.example.lightweightprojects.auth;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.lightweightprojects.entity.Account;

@Service
public class SessionService {
    private Long tokenLifetime;
    private HashMap<String, Date> activeSesions;
    private MessageDigest messageDigest;
    
    public SessionService() throws NoSuchAlgorithmException {
        tokenLifetime = 1000L * 60L * 60L * 24L;
        activeSesions = new HashMap<String, Date>();
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    public boolean isActiveSession(String token) {
        if (activeSesions.containsKey(token)
            && activeSesions.get(token).before(new Date())) {
            return true;
        }

        closeSession(token);
        return false;
    }

    public String generateSessionToken(Account account) {
        Date deadlock = new Date(System.currentTimeMillis() + tokenLifetime);
        String token = encode(account.getLogin(), deadlock);

        activeSesions.put(token, deadlock);
        return token;
    }

    public void closeSession(String token) {
        activeSesions.remove(token);
    }

    public String encode(String token, Date date) {
        StringBuilder stringBuilder = new StringBuilder(token);
        stringBuilder.append(date.getTime());

        return new String(
            messageDigest.digest(stringBuilder.toString().getBytes()),
            StandardCharsets.UTF_8);
    }
}
