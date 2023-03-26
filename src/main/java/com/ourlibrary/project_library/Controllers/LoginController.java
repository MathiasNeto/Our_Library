package com.ourlibrary.project_library.Controllers;

import com.ourlibrary.project_library.dto.StudentDTO;
import com.ourlibrary.project_library.entities.Login;
import com.ourlibrary.project_library.entities.Student;
import com.ourlibrary.project_library.services.LoginService;
import com.ourlibrary.project_library.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private LoginService service;

    @PostMapping
    public ResponseEntity<Login> insert(@RequestBody Login login){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(login));
    }
}
