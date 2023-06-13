package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Login;
import com.ourlibrary.project_library.entities.Users;
import com.ourlibrary.project_library.repositories.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public Login insert(Login login){
        return loginRepository.save(login);
    }
    public Users search(String email, String password){
        return loginRepository.findByUser(email,password)
                .orElseThrow(() -> new ObjectNotFoundException("User Not Found"));
}
}
