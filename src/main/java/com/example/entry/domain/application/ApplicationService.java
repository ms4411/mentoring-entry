package com.example.entry.domain.application;

import com.example.entry.domain.User.UserRepository;
import com.example.entry.domain.enums.AreaEnum;
import com.example.entry.domain.enums.GenderEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    public String createTempApplication(
            Long userId
    ){
        Application application =Application.builder()
                .user(userRepository.findById(userId).orElseThrow())
                .build();
        applicationRepository.save(application);
        return "임시 지원서가 성공적으로 생성되었습니다";
    }

    @Transactional
    public Application inputPersonalData(
            Long id,
            String name,
            LocalDate birthday,
            AreaEnum area,
            GenderEnum gender
    ){
        Application application = applicationRepository.findById(id).orElseThrow();
        application.setPersonalData(name, birthday, area, gender);
        return application;
    }

    @Transactional
    public Application inputSelfIntroduction(Long id, String selfIntroduction){
        Application application =applicationRepository.findById(id).orElseThrow();
        application.setSelfIntroduction(selfIntroduction);
        return application;
    }

    @Transactional
    public Application inputAcademicPlan(Long id, String academicPlan){
        Application application =applicationRepository.findById(id).orElseThrow();
        application.setAcademicPlan(academicPlan);
        return application;
    }

    @Transactional
    public String submit(Long id){
        Application application=applicationRepository.findById(id).orElseThrow();
        application.submit();
        return "지원서 제출 성공";
    }

    public Application applicationDelete(Long id){
        Application temp=applicationRepository.findById(id).orElseThrow();
        applicationRepository.delete(temp);
        return temp;
    }
    public Application applicationGet(Long userId){
        return applicationRepository.findByUser(
                userRepository.findById(userId).orElseThrow()
        ).orElseThrow();
    }
}
