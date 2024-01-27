package com.batikan.courseapp.service;

import com.batikan.courseapp.dto.CourseDto;
import com.batikan.courseapp.dto.converter.CourseDtoConverter;
import com.batikan.courseapp.dto.request.CreateCourseRequest;
import com.batikan.courseapp.dto.request.UpdateCourseRequest;
import com.batikan.courseapp.dto.request.UpdateCourseTeacherRequest;
import com.batikan.courseapp.model.Course;
import com.batikan.courseapp.model.Teacher;
import com.batikan.courseapp.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherService teacherService;
    private final CourseDtoConverter courseDtoConverter;

    public CourseService(CourseRepository courseRepository, TeacherService teacherService, CourseDtoConverter courseDtoConverter) {
        this.courseRepository = courseRepository;
        this.teacherService = teacherService;
        this.courseDtoConverter = courseDtoConverter;
    }

    public CourseDto createCourse(CreateCourseRequest createCourseRequest){
        Teacher teacher = teacherService.findById(createCourseRequest.teacher_id());

        Course course = new Course(
                createCourseRequest.courseName(),
                createCourseRequest.weekday(),
                teacher,
                new ArrayList<>());

        return courseDtoConverter.convert(courseRepository.save(course));
    }

    protected Course findById(String id){
        return courseRepository.findById(id).orElseThrow(
                //TODO create custom exception
                RuntimeException::new
        );
    }

    public CourseDto getCourseById(String course_id){
        return courseDtoConverter.convert(findById(course_id));
    }

    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll().stream().map(courseDtoConverter::convert).collect(Collectors.toList());
    }

    public CourseDto updateCourseTeacher(String course_id,UpdateCourseTeacherRequest updateCourseTeacherRequest){
        Teacher teacher = teacherService.findById(updateCourseTeacherRequest.teacher_id());
        Course course = findById(course_id);
        course.setTeacher(teacher);

        return courseDtoConverter.convert(courseRepository.save(course));
    }

    public CourseDto updateCourseById(String course_id, UpdateCourseRequest updateCourseRequest){
        Course course = findById(course_id);
        course.setName(updateCourseRequest.name());
        course.setWeekday(updateCourseRequest.weekday());
        return courseDtoConverter.convert(courseRepository.save(course));
    }

    public void deleteCourseById(String course_id) {
        Course course = findById(course_id);
        courseRepository.delete(course);
    }
}
