package com.ourlibrary.project_library.Controllers;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Course;
import com.ourlibrary.project_library.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<Course> insert(@RequestBody Course course){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(course));
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<Course>> findAll(){
        List<Course> bookList = service.findAll();
        return ResponseEntity.ok(bookList);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}
