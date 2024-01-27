package com.batikan.courseapp.controller;

import com.batikan.courseapp.dto.CourseDto;
import com.batikan.courseapp.dto.request.CreateCourseRequest;
import com.batikan.courseapp.dto.request.UpdateCourseRequest;
import com.batikan.courseapp.dto.request.UpdateCourseTeacherRequest;
import com.batikan.courseapp.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CreateCourseRequest createCourseRequest){
        return ResponseEntity.ok(courseService.createCourse(createCourseRequest));
    }
    @GetMapping("/{course_id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable String course_id){
        return ResponseEntity.ok(courseService.getCourseById(course_id));
    }
    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PatchMapping("/{course_id}")
    public ResponseEntity<CourseDto> updateCourseTeacher(@PathVariable String course_id,@Valid @RequestBody UpdateCourseTeacherRequest updateCourseTeacherRequest){
        return ResponseEntity.ok(courseService.updateCourseTeacher(course_id,updateCourseTeacherRequest));
    }
    @PutMapping("/{course_id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable String course_id, @Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        return ResponseEntity.ok(courseService.updateCourseById(course_id,updateCourseRequest));
    }


    @DeleteMapping("/{course_id}")
    public void deleteCourse(@PathVariable String course_id){
        courseService.deleteCourseById(course_id);

    }

}
