package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.CourseTeacherDto;
import com.batikan.courseapp.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class CourseTeacherDtoConverter {
    // Teacher to CourseTeacher

    public CourseTeacherDto convert(Teacher from){
        return new CourseTeacherDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getEmail(),
                from.getPassword(),
                from.getTelno()
        );
    }
}
