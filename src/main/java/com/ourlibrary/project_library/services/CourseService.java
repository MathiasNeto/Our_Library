package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Contact;
import com.ourlibrary.project_library.entities.Course;
import com.ourlibrary.project_library.repositories.CourseRespository;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private Validator validator;
    private final CourseRespository courseRespository;

    public Course insert( Course course){
        return courseRespository.save(course);
    }


    public List<Course> findAll() {
        return courseRespository.findAll();
    }

    public Course findById( Long id) {
        return courseRespository.findById(id).orElseThrow(()->new ObjectNotFoundException("Id Not FOUND"));
    }
    public void delCourse(Long id){
        courseRespository.deleteById(id);
    }
}
