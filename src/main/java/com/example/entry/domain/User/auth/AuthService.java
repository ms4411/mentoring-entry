package com.example.entry.domain.User.auth;

import com.example.entry.domain.User.User;
import com.example.entry.domain.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    final private UserRepository userRepository;
    final private PasswordEncoder passwordEncoder;

    public String signUp(String phoneNum, String pw, String checkPw){
        User user=new User(phoneNum, passwordEncoder.encode(pw));
        if(!pw.equals(checkPw)){
            throw new IllegalArgumentException();
        }
        userRepository.save(user);
        return "회원가입 성공";
    }

    public String signIn(String phoneNum, String pw){
        User user = userRepository.findByPhoneNum(phoneNum).orElseThrow();
        if(!passwordEncoder.matches(pw, user.getPw())){
            throw new IllegalArgumentException();
        }
        return "토큰 던지기";
    }
}
