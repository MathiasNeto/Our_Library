package com.ourlibrary.project_library.Controllers;

import com.ourlibrary.project_library.dto.UserDTO;
import com.ourlibrary.project_library.entities.Student;
import com.ourlibrary.project_library.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(student));
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> userDTOList = service.findAll();
        return ResponseEntity.ok(userDTOList);
    }
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}
