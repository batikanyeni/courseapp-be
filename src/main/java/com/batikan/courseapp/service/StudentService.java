package com.batikan.courseapp.service;


import com.batikan.courseapp.dto.StudentDto;
import com.batikan.courseapp.dto.converter.StudentDtoConverter;
import com.batikan.courseapp.dto.request.CreateStudentRequest;
import com.batikan.courseapp.exception.IdNotFoundException;
import com.batikan.courseapp.model.Student;
import com.batikan.courseapp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentDtoConverter studentDtoConverter;

    public StudentService(StudentRepository studentRepository, StudentDtoConverter studentDtoConverter) {
        this.studentRepository = studentRepository;
        this.studentDtoConverter = studentDtoConverter;
    }

    public StudentDto createStudent(CreateStudentRequest createStudentRequest){
        Student student = new Student(
                createStudentRequest.name(),
                createStudentRequest.surname(),
                createStudentRequest.email(),
                createStudentRequest.password(),
                createStudentRequest.telno(),
                new ArrayList<>()
        );

        return studentDtoConverter.convert(studentRepository.save(student));
    }
    protected Student findById(String id){
        return studentRepository.findById(id).orElseThrow(
                () -> new IdNotFoundException("Student does not exist by id: "+id)
        );
    }
    public List<StudentDto> getAllStudents(){
        return studentRepository.findAll().stream().map(studentDtoConverter::convert).collect(Collectors.toList());
    }
    public StudentDto getStudentById(String student_id){
        return studentDtoConverter.convert(findById(student_id));
    }
    public void deleteStudentById(String student_id){
        studentRepository.delete(findById(student_id));
    }
}
