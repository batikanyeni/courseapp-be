package com.batikan.courseapp.dto.converter;

import com.batikan.courseapp.dto.StudentDto;
import com.batikan.courseapp.model.Student;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StudentDtoConverter {
    //Student to StudentDto

    private final EnrollDtoConverter enrollDtoConverter;

    public StudentDtoConverter(EnrollDtoConverter enrollDtoConverter) {
        this.enrollDtoConverter = enrollDtoConverter;
    }

    public StudentDto convert(Student from){
        return new StudentDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getEmail(),
                from.getPassword(),
                from.getTelno(),
                from.getEnrollList().stream().map(enrollDtoConverter::convert).collect(Collectors.toList())
        );
    }
}
