package com.ourlibrary.project_library.Controllers;

import com.ourlibrary.project_library.dto.StudentDTO;
import com.ourlibrary.project_library.entities.Student;
import com.ourlibrary.project_library.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class UserController {
    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(student));
    }
    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll(){
        List<StudentDTO> studentDTOList = service.findAll();
        return ResponseEntity.ok(studentDTOList);
    }
}
