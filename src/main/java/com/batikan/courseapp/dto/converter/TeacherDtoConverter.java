package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.TeacherDto;
import com.batikan.courseapp.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeacherDtoConverter {
    // Teacher to TeacherDto

    private final TeacherCourseDtoConverter teacherCourseDtoConverter;

    public TeacherDtoConverter(TeacherCourseDtoConverter teacherCourseDtoConverter) {
        this.teacherCourseDtoConverter = teacherCourseDtoConverter;
    }

    public TeacherDto convert(Teacher from){
        return new TeacherDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getEmail(),
                from.getPassword(),
                from.getTelno(),
                from.getCourses().stream().map(teacherCourseDtoConverter::convert).collect(Collectors.toList()));
    }
}
