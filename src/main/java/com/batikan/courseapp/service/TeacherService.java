package com.batikan.courseapp.service;


import com.batikan.courseapp.dto.TeacherDto;
import com.batikan.courseapp.dto.converter.TeacherDtoConverter;
import com.batikan.courseapp.dto.request.CreateTeacherRequest;
import com.batikan.courseapp.dto.request.UpdateTeacherRequest;
import com.batikan.courseapp.model.Teacher;
import com.batikan.courseapp.repository.TeacherRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherDtoConverter teacherDtoConverter;

    public TeacherService(TeacherRepository teacherRepository, TeacherDtoConverter teacherDtoConverter) {
        this.teacherRepository = teacherRepository;
        this.teacherDtoConverter = teacherDtoConverter;
    }

    public TeacherDto createTeacher(CreateTeacherRequest createTeacherRequest){
        Teacher teacher = new Teacher(
                createTeacherRequest.name(),
                createTeacherRequest.Surname(),
                createTeacherRequest.email(),
                createTeacherRequest.password(),
                createTeacherRequest.telno(),
                new ArrayList<>()
                );
        return teacherDtoConverter.convert(teacherRepository.save(teacher));
    };

    protected Teacher findById(String id){
        return teacherRepository.findById(id).orElseThrow(
                    //TODO create custom exception
                RuntimeException::new
        );
    }

    public TeacherDto getTeacherById(String teacher_id){
        return teacherDtoConverter.convert(findById(teacher_id));
    }

    public List<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll().stream().map(teacherDtoConverter::convert).collect(Collectors.toList());

    }
    public TeacherDto updateTeacherbyId(String teacher_id, UpdateTeacherRequest updateTeacherRequest){
        Teacher teacher = findById(teacher_id);
        teacher.setName(updateTeacherRequest.name());
        teacher.setSurname(updateTeacherRequest.Surname());
        teacher.setEmail(updateTeacherRequest.email());
        teacher.setPassword(updateTeacherRequest.password());
        teacher.setTelno(updateTeacherRequest.telno());

        return teacherDtoConverter.convert(teacherRepository.save(teacher));
    }
    public void deleteTeacherById(String teacher_id){
        Teacher teacher = findById(teacher_id);
        teacherRepository.delete(teacher);
    }
}
