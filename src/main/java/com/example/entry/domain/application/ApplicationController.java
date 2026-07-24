package com.example.entry.domain.application;

import com.example.entry.domain.application.dto.PersonalDataDTO;
import com.example.entry.domain.application.dto.TextDataDTO;
import com.example.entry.global.common.res.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;
    private final ResponseUtil responseUtil;
    @PostMapping()
    public ResponseEntity<Map<String,String>> applicationCreate(Long userId){
        return responseUtil.resMessage(applicationService.createTempApplication(userId), HttpStatus.CREATED);
    }
    @PatchMapping("/{id}/personalData")
    public ResponseEntity<Application> personalDataInput(PersonalDataDTO personalData){
        return ResponseEntity.ok(applicationService.inputPersonalData(
                personalData.id(),
                personalData.name(),
                personalData.birthday(),
                personalData.area(),
                personalData.gender()
        ));
    }
    @PatchMapping("/selfIntroduction")
    public ResponseEntity<Application> selfIntroductionInput(TextDataDTO textDataDTO){
        return ResponseEntity.ok(
                applicationService.inputSelfIntroduction(textDataDTO.id(), textDataDTO.text())
        );
    }
    @PatchMapping("/academicPlan")
    public ResponseEntity<Application> academicPlanInput(TextDataDTO textDataDTO){
        return ResponseEntity.ok(
                applicationService.inputAcademicPlan(textDataDTO.id(), textDataDTO.text())
        );
    }
    @PatchMapping("/{id}/submit")
    public ResponseEntity<Map<String, String>> submit(Long id){
        return responseUtil.resMessage(applicationService.submit(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Application> applicationDelete(Long id){
        return ResponseEntity.ok(applicationService.applicationDelete(id));
    }
    @GetMapping()
    public ResponseEntity<Application> applicationGet(Long userId){
        return ResponseEntity.ok(applicationService.applicationGet(userId));
    }
}
