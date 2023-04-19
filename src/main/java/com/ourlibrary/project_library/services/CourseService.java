package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Course;
import com.ourlibrary.project_library.repositories.CourseRepository;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private Validator validator;
    private final CourseRepository courseRepository;

    public Course insert( Course course){
        return courseRepository.save(course);
    }


    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById( Long id) {
        return courseRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("Id Not FOUND"));
    }
    public void delCourse(Long id){
        courseRepository.deleteById(id);
    }
}
