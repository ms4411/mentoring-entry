package com.example.entry.global.common.res;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseUtil {
    //메세지 반환
    public ResponseEntity<Map<String, String>> resMessage(String message, HttpStatus statusCode){
        return ResponseEntity.status(statusCode).body(Map.of("message", message));
    }
    public ResponseEntity<Map<String, String>> resMessage(String message){
        return ResponseEntity.ok(Map.of("message", message));
    }
    //토큰 반환
    public ResponseEntity<Map<String, String>> resToken(String token){
        return ResponseEntity.ok(Map.of("Authorization", token));
    }
}
