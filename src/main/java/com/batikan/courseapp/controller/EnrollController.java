package com.batikan.courseapp.controller;

import com.batikan.courseapp.dto.EnrollDto;
import com.batikan.courseapp.dto.request.CreateEnrollRequest;
import com.batikan.courseapp.service.EnrollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/enroll")
public class EnrollController {
    private final EnrollService enrollService;

    public EnrollController(EnrollService enrollService) {
        this.enrollService = enrollService;
    }

    @PostMapping
    public ResponseEntity<EnrollDto> createEnroll(@RequestBody  CreateEnrollRequest createEnrollRequest){
        return ResponseEntity.ok(enrollService.createEnroll(createEnrollRequest));
    }
    @GetMapping
    public ResponseEntity<List<EnrollDto>> getAllEnrolls(){
        return ResponseEntity.ok(enrollService.getAllEnrolls());
    }

    @GetMapping("/{enroll_id}")
    public ResponseEntity<EnrollDto> getEnrollById(@PathVariable String enroll_id){
        return ResponseEntity.ok(enrollService.getEnrollById(enroll_id));
    }
    @DeleteMapping("/{enroll_id}")
    public void deleteEnrollById(@PathVariable String enroll_id){
        enrollService.deleteEnrollById(enroll_id);
    }
}
