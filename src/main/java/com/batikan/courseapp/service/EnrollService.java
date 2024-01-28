package com.batikan.courseapp.service;


import com.batikan.courseapp.dto.EnrollDto;
import com.batikan.courseapp.dto.converter.EnrollDtoConverter;
import com.batikan.courseapp.dto.request.CreateEnrollRequest;
import com.batikan.courseapp.exception.IdNotFoundException;
import com.batikan.courseapp.model.Enroll;
import com.batikan.courseapp.repository.EnrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollService {
    private final EnrollRepository enrollRepository;
    private final EnrollDtoConverter enrollDtoConverter;
    private  final  StudentService studentService;
    private final  CourseService courseService;

    public EnrollService(EnrollRepository enrollRepository, EnrollDtoConverter enrollDtoConverter, StudentService studentService, CourseService courseService) {
        this.enrollRepository = enrollRepository;
        this.enrollDtoConverter = enrollDtoConverter;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public EnrollDto createEnroll(CreateEnrollRequest createEnrollRequest){
        Enroll enroll = new Enroll(
                studentService.findById(createEnrollRequest.student_id()),
                courseService.findById(createEnrollRequest.course_id())
        );

        return enrollDtoConverter.convert(enrollRepository.save(enroll));
    }
    protected Enroll findById(String id){
        return enrollRepository.findById(id).orElseThrow(
                () -> new IdNotFoundException("Enroll does not exists by id: " +id)
        );
    }
    public List<EnrollDto> getAllEnrolls(){
        return enrollRepository.findAll().stream().map(enrollDtoConverter::convert).collect(Collectors.toList());
    }

    public EnrollDto getEnrollById(String enroll_id) {
        return enrollDtoConverter.convert(findById(enroll_id));
    }

    public void deleteEnrollById(String enroll_id){
        enrollRepository.delete(findById(enroll_id));
    }
}
