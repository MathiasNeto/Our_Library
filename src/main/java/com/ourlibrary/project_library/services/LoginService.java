package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Login;
import com.ourlibrary.project_library.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository repository;

    public Login insert(Login login){
        return repository.save(login);
    }
}
