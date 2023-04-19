package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Login;
import com.ourlibrary.project_library.repositories.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository repository;

    public Login insert(Login login){
        return repository.save(login);
    }
}
