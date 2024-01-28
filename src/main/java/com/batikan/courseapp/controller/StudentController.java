package com.batikan.courseapp.controller;

import com.batikan.courseapp.dto.StudentDto;
import com.batikan.courseapp.dto.request.CreateStudentRequest;
import com.batikan.courseapp.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        return ResponseEntity.ok(studentService.createStudent(createStudentRequest));
    }
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    @GetMapping("/{student_id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String student_id){
        return ResponseEntity.ok(studentService.getStudentById(student_id));
    }

    @DeleteMapping("/{student_id}")
    public void deleteStudentById(@PathVariable String student_id){
        studentService.deleteStudentById(student_id);
    }

}
