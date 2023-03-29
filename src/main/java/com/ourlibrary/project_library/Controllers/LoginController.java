package com.ourlibrary.project_library.Controllers;

import com.ourlibrary.project_library.entities.Login;
import com.ourlibrary.project_library.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
