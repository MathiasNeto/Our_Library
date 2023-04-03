package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Login;
import com.ourlibrary.project_library.repositories.LoginRepository;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository repository;

    public Login insert(@Valid Login login){
        return repository.save(login);
    }
}
