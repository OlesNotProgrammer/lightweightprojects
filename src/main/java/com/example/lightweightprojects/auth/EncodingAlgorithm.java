package com.example.lightweightprojects.auth;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class EncodingAlgorithm {
    private final MessageDigest messageDigest;

    public EncodingAlgorithm() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    public String encode(String token, Date date) {
        StringBuilder stringBuilder = new StringBuilder(token);
        stringBuilder.append(date.getTime());

        return new String(
            messageDigest.digest(stringBuilder
                .toString()
                .getBytes()),
            StandardCharsets.UTF_8);
    }
}
