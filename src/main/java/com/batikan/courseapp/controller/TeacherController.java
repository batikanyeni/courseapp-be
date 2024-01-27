package com.batikan.courseapp.controller;

import com.batikan.courseapp.dto.TeacherDto;
import com.batikan.courseapp.dto.request.CreateTeacherRequest;
import com.batikan.courseapp.dto.request.UpdateTeacherRequest;
import com.batikan.courseapp.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping("/{teacher_id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable String teacher_id){
        return ResponseEntity.ok(teacherService.getTeacherById(teacher_id));
    }
    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers(){
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }
    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@Valid @RequestBody CreateTeacherRequest createTeacherRequest){
        return ResponseEntity.ok(teacherService.createTeacher(createTeacherRequest));
    }
    @PutMapping("/{teacher_id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable String teacher_id, @Valid @RequestBody UpdateTeacherRequest updateTeacherRequest){
        return ResponseEntity.ok(teacherService.updateTeacherbyId(teacher_id,updateTeacherRequest));
    }
    @DeleteMapping("/{teacher_id}")
    public void deleteTeacherById(@PathVariable String teacher_id){
        teacherService.deleteTeacherById(teacher_id);

    }

}
