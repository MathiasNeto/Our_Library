package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Course;
import com.ourlibrary.project_library.repositories.BookRespository;
import com.ourlibrary.project_library.repositories.CourseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRespository repository;

    public Course insert(Course course){
        return repository.save(course);
    }


    public List<Course> findAll() {
        return repository.findAll();
    }

    public Course findById(Long id) {
        return repository.findById(id).get();
    }
}
