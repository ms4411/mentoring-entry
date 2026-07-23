package com.example.entry.domain.User.auth;

import com.example.entry.domain.User.dto.SignInDTO;
import com.example.entry.domain.User.dto.SignUpDTO;
import com.example.entry.global.common.res.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    final private AuthService authService;
    final private ResponseUtil responseUtil;

    @PostMapping
    public ResponseEntity<Map<String,String>> signUp(SignUpDTO singUpDTO){
        String message=authService.signUp(
                singUpDTO.phoneNumber(),
                singUpDTO.password(),
                singUpDTO.checkPassword()
        );

        return responseUtil.resMessage(message, HttpStatus.CREATED);
    }

    @PostMapping("/signIn")
    public ResponseEntity<Map<String,String>> signIn(SignInDTO signInDTO){
        String token= authService.signIn(signInDTO.phoneNumber(), signInDTO.password());
        return responseUtil.resToken(token);
    }
}
